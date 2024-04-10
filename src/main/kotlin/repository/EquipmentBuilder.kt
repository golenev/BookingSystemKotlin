package repository

import enums.EquipmentType
import manager.EquipmentManager
import pojo.EquipmentModel

class EquipmentBuilder : EquipmentManager {

    override fun create(quantity: Int, equipmentType: EquipmentType): EquipmentModel {
        return EquipmentModel(quantity, equipmentType)
    }
}