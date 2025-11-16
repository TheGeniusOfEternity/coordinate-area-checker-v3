package beans

import jakarta.faces.view.ViewScoped
import jakarta.inject.Named
import java.io.Serializable

@ViewScoped
@Named("startPageBean")
class StartPageBean: Serializable {
    fun goToMainPage(): String {
        println("go to main page page")
        return "success";
    }
}