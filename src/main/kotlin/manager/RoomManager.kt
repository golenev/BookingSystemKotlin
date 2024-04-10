package manager

import enums.RoomType
import pojo.EquipmentModel
import pojo.RoomModel

interface RoomManager {

    fun create(id: Int, uniqueName: String, maxCapacity: Int, equipmentModels: List<EquipmentModel>, roomType: RoomType) : RoomModel
    fun delete(id : Int)
    fun find(roomModel: RoomModel)

}