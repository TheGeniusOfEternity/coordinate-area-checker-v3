package beans

import jakarta.faces.view.ViewScoped
import jakarta.inject.Named
import java.io.Serializable
import java.time.LocalDateTime
import java.time.ZonedDateTime


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

    fun updateTime() {
        this.dateTime = LocalDateTime.now()
    }

    fun getDateTimeMillis(): Long {
        return ZonedDateTime
            .of(dateTime, java.time.ZoneId.systemDefault())
            .toInstant()
            .toEpochMilli()
    }
}