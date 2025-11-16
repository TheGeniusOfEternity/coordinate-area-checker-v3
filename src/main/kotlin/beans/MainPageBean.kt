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

    fun getX(): Int? {
        return x
    }

    fun setX(x: String?) {
        this.x = x?.toIntOrNull()
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

    fun setR(r: String?) {
        this.r = r?.toIntOrNull()
    }

    fun submitForm(): String {
        println("X: " + this.x)
        println("Y: " + this.y)
        println("R: " + this.r)

        // Обработка данных
        return "success"
    }
}