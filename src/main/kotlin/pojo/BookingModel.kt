package pojo

import java.time.LocalDateTime

data class BookingModel(
    val roomModel: RoomModel,
    val arrivalDate: LocalDateTime,
    val departureDay: LocalDateTime
)
