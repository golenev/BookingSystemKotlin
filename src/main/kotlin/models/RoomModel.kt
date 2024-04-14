package models

import enums.RoomType

data class RoomModel(
    val id: Int,
    val uniqueName: String,
    val maxCapacity: Int,
    val equipmentModel: EquipmentModel,
    val roomType: RoomType
)
