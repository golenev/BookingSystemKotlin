import enums.RoomSize
import enums.RoomType
import util.DateFormatter
import pojo.BookingModel
import pojo.InvoiceModel
import services.MeetingRoomService
import java.util.*

class EntryPoint {

    val scanner = Scanner(System.`in`)

    fun dealRegister(): BookingModel {
        println("=============WELCOME===================")

        println("На сколько человек нужна переговорка?")
        val numberOfPeople = scanner.nextInt()

        println("С какого числа вы хотите забронировать переговорк. Введите даты в формате дд.мм.гггг")
        val inputDate = scanner.next()
        val currentDate = DateFormatter().convertStringToDate(inputDate)

        println("На сколько дней вы хотите забронировать переговорку")
        val daysQuantity = scanner.nextInt()

        println("Какой размер переговорки вас интересует (1. маленький, 2. средний, 3. большой)? введите, соответствующую цифру")
        val purposeInput = scanner.nextInt()
        val roomSize = RoomSize.entries[purposeInput - 1]

        println("Какой тип переговорки вам нужен (1. Standart, 2.Конференц зал, 3. Relax ? введите, соответствующую цифру")
        val roomTypeInput = scanner.nextInt()
        val roomType = RoomType.entries[roomTypeInput - 1]

        println("Спасибо, сейчас проверим свободные слоты")

        for (i in 0 until 10) {
            val ast = "*"
            Thread.sleep(200)
            print("$ast ")
        }
        return BookingModel(
            roomSize,
            roomType,
            numberOfPeople,
            currentDate,
            currentDate.plusDays(daysQuantity.toLong())
        )
    }


}
        fun main() {
            val entryPoint = EntryPoint()
            val requestedRoom = entryPoint.dealRegister()
            MeetingRoomService().findAvailableRoom(requestedRoom)
            println("Желаемая переговорка свободна. Давайте зарегистрируемся \n")
            println("Введите ваше имя и мы выдадим вам инвоис")
            val nameInput = entryPoint.scanner.next()
            val invoice = InvoiceModel(requestedRoom, 1, nameInput)
            MeetingRoomService().makeBooking(invoice)
        }

