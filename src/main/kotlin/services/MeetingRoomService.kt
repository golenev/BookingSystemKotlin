package services


import pojo.BookingModel
import repository.MeetingRoomRepository
import util.FileUtils
import java.time.LocalDateTime
import kotlin.system.exitProcess


class MeetingRoomService {
    private fun isOverlapping(start1: LocalDateTime, end1: LocalDateTime, start2: LocalDateTime, end2: LocalDateTime): Boolean {
        return start1.isBefore(end2) && start2.isBefore(end1)
    }

    fun findAvailableRoom(bookingModel: BookingModel) {
        val roomOptional = MeetingRoomRepository()
            .getMeetingRooms()
            .filter { room -> room.roomSize == bookingModel.roomSize && room.roomType == bookingModel.roomType }
            .firstOrNull { room ->
                !isOverlapping(
                    bookingModel.arrivalDate,
                    bookingModel.departureDay,
                    room.arrivalDate,
                    room.departureDay
                )
            }
        roomOptional?.let {
            println("Room of type ${bookingModel.roomType} with size ${bookingModel.roomSize} is available.")
        } ?: run {
            println("No room of type ${bookingModel.roomType} with size ${bookingModel.roomSize} is available.")
            println("К сожалению забронировать не удастся")
            exitProcess(0)
        }
    }

    fun makeBooking(obj: Any) {
        FileUtils().saveObjectAsJson(obj)
    }

}
