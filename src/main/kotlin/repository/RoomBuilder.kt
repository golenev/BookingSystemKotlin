package repository

import enums.RoomType
import manager.RoomManager
import pojo.EquipmentModel
import pojo.RoomModel

class RoomBuilder : RoomManager {

    override fun create(
        id: Int,
        uniqueName: String,
        maxCapacity: Int,
        equipmentModels: List<EquipmentModel>,
        roomType: RoomType
    ): RoomModel {
        return RoomModel(id, uniqueName, maxCapacity, equipmentModels, roomType)
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    override fun find(roomModel: RoomModel) {
        TODO("Not yet implemented")
    }
}

