package interfaces

import enums.RoomType
import models.EquipmentModel
import models.RoomModel

interface RoomManager {
    fun create(
        id: Int,
        uniqueName: String,
        maxCapacity: Int,
        equipmentModel: EquipmentModel,
        roomType: RoomType
    ): RoomModel

    fun delete(id: Int)
    fun find(roomModel: RoomModel)
}