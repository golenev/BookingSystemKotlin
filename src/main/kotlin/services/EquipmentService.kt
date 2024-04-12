package services

import enums.EquipmentType
import interfaces.EquipmentManager
import models.EquipmentModel

class EquipmentService : EquipmentManager {

    override fun create(quantity: Int, equipmentType: EquipmentType): EquipmentModel {
        return EquipmentModel(quantity, equipmentType)
    }
}