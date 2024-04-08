package manager

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.management.Query.div

class DateFormatter {
    fun convertStringToDate(dateString: String?): LocalDateTime {
        // Определение формата даты
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        // Преобразование строки в LocalDate // // Преобразование LocalDate в LocalDateTime на начало дня (полночь)
        return LocalDate.parse(dateString.toString(), formatter).atStartOfDay()
    }

}