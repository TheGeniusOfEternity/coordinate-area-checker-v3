package beans

import jakarta.faces.view.ViewScoped
import jakarta.inject.Named
import java.io.Serializable

@ViewScoped
@Named("mainPageBean")
class MainPageBean: Serializable {
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

    fun submitForm(): String {
        println("X: " + this.x)
        println("Y: " + this.y)
        println("R: " + this.r)

        // Обработка данных
        return "success"
    }

    fun goToStartPage(): String {
        return "success"
    }
}