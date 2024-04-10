package pojo

import enums.RoomType

data class RoomModel(
    val id: Int,
    val uniqueName: String,
    val maxCapacity: Int,
    val equipmentModels: List<EquipmentModel>,
    val roomType: RoomType
)
{
    constructor(id: Int, uniqueName: String, maxCapacity: Int) : this()
}