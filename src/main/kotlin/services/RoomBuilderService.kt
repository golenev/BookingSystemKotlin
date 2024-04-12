package services

import enums.RoomType
import interfaces.RoomManager
import models.EquipmentModel
import models.RoomModel

class RoomBuilderService : RoomManager {

    override fun create(id: Int, uniqueName: String, maxCapacity: Int, equipmentModels: List<EquipmentModel>, roomType: RoomType): RoomModel {
        return RoomModel(id, uniqueName, maxCapacity, equipmentModels, roomType)
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    override fun find(roomModel: RoomModel) {
        TODO("Not yet implemented")
    }
}

