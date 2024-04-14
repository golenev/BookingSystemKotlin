import enums.EquipmentType
import enums.RoomType
import models.EquipmentModel
import models.RequestRoom
import org.junit.jupiter.api.Test
import services.EventManagerService
import util.JsonReader

class BookingTest {

    @Test
    fun test() {
        //получаем исходный список случайных объектов всех комнат
        val roomEntitiesList = EventManagerService().buildRoomsCollection();
        //создаём "таблицу" с сущностями и кладём туда все комнаты
        EventManagerService().insertEntitiesToDataBase(roomEntitiesList, "roomList");
        //парсим её в список объектов
        val roomEntitiesTable = JsonReader().objectifyJson("booking_roomList.json")
        //создаём запрос на комнату от клиента желающего забронировать
        val requestRoom = RequestRoom(7, EquipmentModel(4, EquipmentType.SCANNER), RoomType.STANDARD_ROOM, "Ivan")
        //отправляем созданный запрос на комнату в метод поиска комнат, которая принимает таблицу и наш запрос
        //опионально получаем комнату
        val reqRoom = EventManagerService().lookForRequiredRoom(roomEntitiesTable, requestRoom)
        //создаём бронирование
        EventManagerService().createBooking(reqRoom, "yourFinalInvoice")
    }

}