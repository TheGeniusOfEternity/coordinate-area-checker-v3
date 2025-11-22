package beans

import entities.Shot
import jakarta.enterprise.context.SessionScoped
import jakarta.inject.Inject
import jakarta.inject.Named
import repositories.ShotRepository
import java.io.Serializable

@SessionScoped
@Named("mainPageBean")
class MainPageBean: Serializable {

    @Inject
    private lateinit var shotRepository: ShotRepository

    private var x: Int? = null
    private var y: Float? = null
    private var r: Int? = null

    private val optionsX = listOf(-5, -4, -3, -2, -1, 0, 1, 2, 3)

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
            shotRepository.save(Shot(
                xVal,
                yVal,
                rVal,
                isHit(xVal, yVal, rVal)
            ))
        }
    }

    fun isHit(x: Int, y: Float, r: Int): Boolean {
        return true
    }

    fun goToStartPage(): String {
        return "success"
    }
}