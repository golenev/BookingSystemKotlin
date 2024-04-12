package interfaces

import enums.EquipmentType
import models.EquipmentModel

interface EquipmentManager {
    fun create (quantity: Int, equipmentType: EquipmentType) : EquipmentModel
}