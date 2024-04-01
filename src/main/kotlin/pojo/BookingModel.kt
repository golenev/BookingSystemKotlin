package pojo

import enums.RoomSize
import enums.RoomType
import java.time.LocalDateTime

data class BookingModel(
    val roomSize: RoomSize,
    val roomType: RoomType,
    val guestsQuantity: Int,
    val arrivalDate: LocalDateTime,
    val departureDay: LocalDateTime
)
