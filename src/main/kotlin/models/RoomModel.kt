package models

import enums.RoomType

data class RoomModel(
    val id: Int,
    val uniqueName: String,
    val maxCapacity: Int,
    val equipmentModels: List<EquipmentModel>,
    val roomType: RoomType
)
