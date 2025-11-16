package beans

import jakarta.faces.view.ViewScoped
import jakarta.inject.Named
import java.io.Serializable
import java.time.LocalDateTime
import java.time.ZonedDateTime


@Named("clockBean")
@ViewScoped
class ClockBean : Serializable {
    private var dateTimeMillis: Long = 0L

    init {
        updateDateTimeMillis()
    }

    fun getDateTimeMillis(): Long {
        return dateTimeMillis
    }

    fun setDateTimeMillis(dateTimeMillis: Long) {
        this.dateTimeMillis = dateTimeMillis
    }

    fun updateDateTimeMillis() {
        this.dateTimeMillis = ZonedDateTime
            .of(LocalDateTime.now(), java.time.ZoneId.systemDefault())
            .toInstant()
            .toEpochMilli()
    }
}