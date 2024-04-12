package models

import enums.RoomType

data class RequestRoom(
    val guestsQuantity: Int,
    val desiredEquipmentModel: EquipmentModel,
    val roomType: RoomType,
    val clientName: String
)
