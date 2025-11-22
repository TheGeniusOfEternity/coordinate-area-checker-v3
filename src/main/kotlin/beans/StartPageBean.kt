package beans

import jakarta.faces.view.ViewScoped
import jakarta.inject.Named
import java.io.Serializable

@ViewScoped
@Named("startPageBean")
class StartPageBean: Serializable {
    fun goToMainPage(): String {
        return "success";
    }
}