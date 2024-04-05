package services


import pojo.BookingModel
import repository.MeetingRoomRepository
import util.FileUtils
import java.time.LocalDateTime
import kotlin.system.exitProcess


class MeetingRoomService {

    /**
     * Проверяет, пересекаются ли два интервала времени.
     *
     * @param start1 Начало первого интервала.
     * @param end1 Конец первого интервала.
     * @param start2 Начало второго интервала.
     * @param end2 Конец второго интервала.
     * @return true, если интервалы пересекаются, иначе false.
     */
    private fun isOverlapping(start1: LocalDateTime, end1: LocalDateTime, start2: LocalDateTime, end2: LocalDateTime): Boolean {
        return start1.isBefore(end2) && start2.isBefore(end1)
    }

    /**
     * 1. Сначала ищем в MeetingRoomRepository() хоть одну переговорку, которая одновременно имеет подходящий тип и размер
     * 2. Найденную переговорку отправляем в метод isOverlapping() для проверки свободности даты
     */
    fun findAvailableRoom(bookingModel: BookingModel) {
        val roomOptional = MeetingRoomRepository()
            .getMeetingRooms()
            .filter { room -> room.roomSize == bookingModel.roomSize && room.roomType == bookingModel.roomType }
            .firstOrNull {
                !isOverlapping(
                    bookingModel.arrivalDate,
                    bookingModel.departureDay,
                    it.arrivalDate,
                    it.departureDay
                )
            }
        roomOptional?.let {
            println("Переговорка типа ${bookingModel.roomType} с размером ${bookingModel.roomSize} доступна к бронированию.")
        } ?: let {
            println("Переговорка типа ${bookingModel.roomType} с размером ${bookingModel.roomSize} недоступна к бронированию")
            println("К сожалению забронировать не удастся")
            exitProcess(0)
        }
    }

    fun makeBooking(obj: Any) {
        FileUtils().saveObjectAsJson(obj)
    }

}
