package services

import com.github.javafaker.Faker
import enums.EquipmentType
import enums.RoomType
import pojo.EquipmentModel
import pojo.RoomModel
import repository.EquipmentBuilder
import repository.RoomBuilder
import util.FileUtils


class MeetingRoomGenerator {
    private val roomBuilder = RoomBuilder()
    private val equipmentBuilder = EquipmentBuilder()
    private val faker = Faker()
    private val rooms = mutableListOf<RoomModel>()

    private fun createRooms(): MutableList<RoomModel> {
        for (i in 1..20) {
            val name = "Room-${faker.funnyName().name()}"
            val maxCapacity = (2..20).random()
            val roomType = RoomType.entries.toTypedArray().random()
            val equipments = mutableListOf<EquipmentModel>()
            val equipmentCount = (1..5).random()
            for (j in 1..equipmentCount) {
                val equipmentType = EquipmentType.entries.toTypedArray().random()
                val quantity = (1..5).random()
                val equipment = equipmentBuilder.create(quantity, equipmentType)
                equipments.add(equipment)
            }
            val room = roomBuilder.create(i, name, maxCapacity, equipments, roomType)
            rooms.add(room)
        }
        return rooms
    }

    fun bootRooms() {
       // val wrapper = mapOf("List" to createRooms())
        // createRooms();
         FileUtils().saveObjectAsJson(createRooms(), "roomList")
    }
}

fun main() {
    MeetingRoomGenerator().bootRooms()
}



