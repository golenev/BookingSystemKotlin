package manager

import enums.EquipmentType
import pojo.EquipmentModel

interface EquipmentManager {
    fun create (quantity: Int, equipmentType: EquipmentType) : EquipmentModel
}