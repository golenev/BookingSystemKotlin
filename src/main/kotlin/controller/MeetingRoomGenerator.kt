package controller

import com.github.javafaker.Faker
import enums.EquipmentType
import enums.RoomType
import models.EquipmentModel
import models.InvoiceModel
import models.RequestRoom
import models.RoomModel
import services.EquipmentService
import services.EventManagerService
import services.RoomBuilderService
import util.FileUtils
import util.JsonReader


class MeetingRoomGenerator {

    private val roomBuilderService = RoomBuilderService()
    private val equipmentService = EquipmentService()
    private val faker = Faker()

    private fun generateOneRoom(): RoomModel {
        val id = (1..20).random()
        val name = "Room-${faker.funnyName().name()}"
        val maxCapacity = (2..20).random()
        val roomType = RoomType.entries.toTypedArray().random()
        val equipments = mutableListOf<EquipmentModel>()
        val equipmentCount = (1..5).random()
        (1..equipmentCount).forEach {
            val equipmentType = EquipmentType.entries.toTypedArray().random()
            val quantity = (1..5).random()
            val equipment = equipmentService.create(quantity, equipmentType)
            equipments.add(equipment)
        }
        return roomBuilderService.create(id, name, maxCapacity, equipments, roomType)
    }

    private fun buildRoomsCollection(): MutableList<RoomModel> {
        val rooms = mutableListOf<RoomModel>()
        for (i in 1..20) {
            val room = generateOneRoom()
            rooms.add(room)
        }
        return rooms
    }

    fun writeRoomsToJson() {
        FileUtils().saveObjectAsJson(buildRoomsCollection(), "roomList")
    }

    fun lookForRequiredRoom() : InvoiceModel {
        val obj = JsonReader().objectifyJson("booking_roomList.json")
        //кладём создаём объект желаемой к бронированию комнаты  и ищем его в списке obj
        val requestRoom = RequestRoom(19, EquipmentModel(4, EquipmentType.SCANNER), RoomType.STANDARD_ROOM, "Ivan")
        val result = EventManagerService().findRoom(requestRoom, obj)
        return InvoiceModel(result, requestRoom.clientName)
    }

}




//fun main() {
//    // MeetingRoomGenerator().writeRoomsToJson()
//
//    FileUtils().saveObjectAsJson( lookForRequiredRoom(), "invoice")
//
//}



