package beans.pages

import entities.Shot
import jakarta.annotation.PostConstruct
import jakarta.enterprise.context.SessionScoped
import jakarta.faces.context.FacesContext
import jakarta.inject.Inject
import jakarta.inject.Named
import repositories.ShotRepository
import java.io.Serializable
import java.util.TimeZone

@SessionScoped
@Named("mainPageBean")
class MainPageBean: Serializable {

    @Inject
    private lateinit var shotRepository: ShotRepository

    private var shots: List<Shot> = listOf()
    private var x: Float? = null
    private var y: Float? = null
    private var r: Int? = null

    private val optionsX = listOf(-5, -4, -3, -2, -1, 0, 1, 2, 3)

    @PostConstruct
    fun init() {
        refreshShots()
    }

    fun getShots(): List<Shot> {
        return shots
    }

    fun getOptionsX(): List<Int> {
        return optionsX
    }

    fun getX(): Float? {
        return x
    }

    fun setX(x: Float?) {
        this.x = x
    }

    fun getY(): Float? {
        return y
    }

    fun setY(y: Float?) {
        this.y = y
    }

    fun getR(): Int? {
        return r
    }

    fun setR(r: Int?) {
        this.r = r
    }

    fun submitForm() {
        val context = FacesContext.getCurrentInstance()
        val requestMap = context.externalContext.requestParameterMap

        val xFromHidden = requestMap["main-form:precisedX"]?.toFloatOrNull()
        val yFromHidden = requestMap["main-form:precisedY"]?.toFloatOrNull()

        val xVal = xFromHidden ?: x
        val yVal = yFromHidden ?: y
        val rVal = r

        if (xVal != null && yVal != null && rVal != null) {
            val shot = shotRepository.save(
                Shot(
                    xVal,
                    yVal,
                    rVal,
                    isHit(xVal, yVal, rVal)
                )
            )
            if (shot != null) refreshShots()
        }
    }

    fun refreshShots() {
        val fetchedShots = shotRepository.getAll()
        if (fetchedShots != null) shots = fetchedShots
    }

    fun isHit(x: Float, y: Float, r: Int): Boolean {
        return when {
            // Triangle
            x >= 0 && y >= 0 -> x + y <= r
            // Empty
            x <= 0 && y >= 0 -> false
            // Square
            x <= 0 && y <= 0 -> x >= -r && y >= -r
            // Circle
            else -> x * x + y * y <= r * r
        }
    }

    fun goToStartPage(): String {
        return "success"
    }

    fun getCurrentTimeZone(): TimeZone {
        return TimeZone.getDefault()
    }
}