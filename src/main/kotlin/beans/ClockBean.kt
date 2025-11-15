package beans

import jakarta.faces.view.ViewScoped
import jakarta.inject.Named
import java.io.Serializable
import java.time.LocalDateTime



@Named("clockBean")
@ViewScoped
class ClockBean : Serializable {
    private var dateTime: LocalDateTime = LocalDateTime.now()

    fun getDateTime(): LocalDateTime {
        return dateTime
    }

    fun setDateTime(dateTime: LocalDateTime) {
        this.dateTime = dateTime
    }
}