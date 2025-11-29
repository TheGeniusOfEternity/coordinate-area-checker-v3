package beans.pages

import entities.Shot
import jakarta.annotation.PostConstruct
import jakarta.faces.view.ViewScoped
import jakarta.inject.Inject
import jakarta.inject.Named
import repositories.ShotRepository
import java.io.Serializable
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.TimeZone

@ViewScoped
@Named("mainPageBean")
class MainPageBean: Serializable {

    @Inject
    private lateinit var shotRepository: ShotRepository

    private var shots: List<Shot> = listOf()
    private var x: Int? = null
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

    fun getX(): Int? {
        return x
    }

    fun setX(x: Int?) {
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
        val xVal = x
        val yVal = y
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

    fun isHit(x: Int, y: Float, r: Int): Boolean {
        if (x <= 0 && y <= 0) return x <= -r && y <= -r
        if (x >= 0 && y >= 0) return x + y <= r
        if (x > 0 && y < 0) return x * x + y * y <= r * r
        return true
    }

    fun goToStartPage(): String {
        return "success"
    }

    fun getCurrentTimeZone(): TimeZone {
        return TimeZone.getDefault()
    }
}