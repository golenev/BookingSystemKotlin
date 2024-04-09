package manager

import enums.RoomType
import pojo.EquipmentModel
import pojo.RoomModel

interface RoomManager {

    fun create(id: Int, name: String, maxCapacity: Int, equipments: List<EquipmentModel>, roomType: RoomType) : RoomModel
    fun delete(id : Int)
    fun find(roomModel: RoomModel)

}