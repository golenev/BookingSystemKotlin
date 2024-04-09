package repository

import enums.EquipmentType
import enums.RoomType
import manager.RoomManager
import pojo.EquipmentModel
import pojo.RoomModel

class RoomBuilder : RoomManager {

    override fun create(id: Int, name: String, maxCapacity: Int, equipments: List<EquipmentModel>, roomType: RoomType): RoomModel {
      return RoomModel(id, name, maxCapacity, equipments, roomType)
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    override fun find(roomModel: RoomModel) {
        TODO("Not yet implemented")
    }
}