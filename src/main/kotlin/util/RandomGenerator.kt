package util

import com.github.javafaker.Faker
import enums.EquipmentType
import enums.RoomType
import models.EquipmentModel
import models.RoomModel
import services.EquipmentService
import services.RoomBuilderService

class RandomGenerator {

    private val roomBuilderService = RoomBuilderService()
    private val equipmentService = EquipmentService()
    private val faker = Faker()

    private fun generateRandomRoom(): RoomModel {
        val id = (1..20).random()
        val name = "Room-${faker.funnyName().name()}"
        val maxCapacity = (2..20).random()
        val roomType = RoomType.entries.toTypedArray().random()
        val equipments = mutableListOf<EquipmentModel>()
        val equipmentCount = (1..5).random()
        for (j in 1..equipmentCount) {
            val equipmentType = EquipmentType.entries.toTypedArray().random()
            val quantity = (1..5).random()
            val equipment = equipmentService.create(quantity, equipmentType)
            equipments.add(equipment)
        }
        return roomBuilderService.create(id, name, maxCapacity, equipments, roomType)
    }

    private fun createRooms(): MutableList<RoomModel> {
        val rooms = mutableListOf<RoomModel>()
        for (i in 1..20) {
            val room = generateRandomRoom()
            rooms.add(room)
        }
        return rooms
    }

}