package pojo

import enums.RoomSize
import enums.RoomType
import java.time.LocalDateTime

data class BookingModel(
    val roomModel: RoomModel,
    val arrivalDate: LocalDateTime,
    val departureDay: LocalDateTime
)
