package models

import enums.EquipmentType

data class EquipmentModel(
    val quantity: Int,
    val equipmentType: EquipmentType
)
