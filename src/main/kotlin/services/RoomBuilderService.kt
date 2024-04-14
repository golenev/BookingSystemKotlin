package services

import com.github.javafaker.Faker
import enums.EquipmentType
import enums.RoomType
import interfaces.RoomManager
import models.EquipmentModel
import models.RoomModel

class RoomBuilderService : RoomManager {

    private val faker = Faker()

    override fun create(
        id: Int,
        uniqueName: String,
        maxCapacity: Int,
        equipmentModel: EquipmentModel,
        roomType: RoomType
    ): RoomModel {
        return RoomModel(id, uniqueName, maxCapacity, equipmentModel, roomType)
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    override fun find(roomModel: RoomModel) {
        TODO("Not yet implemented")
    }

    /**
     * Создаём одну переговорку, заполняем поля случайными данными
     */
    fun generateOneRoom(): RoomModel {
        val id = (1..20).random()
        val name = "Room-${faker.funnyName().name()}"
        val maxCapacity = (2..20).random()
        val roomType = RoomType.entries.toTypedArray().random()
        val equipment =
            EquipmentService().create(faker.random().nextInt(1, 10), EquipmentType.entries.toTypedArray().random());
        return RoomBuilderService().create(id, name, maxCapacity, equipment, roomType)
    }

}

