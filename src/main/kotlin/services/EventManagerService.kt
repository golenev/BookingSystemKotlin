package services

import interfaces.EventManager
import models.InvoiceModel
import models.RequestRoom
import models.RoomModel

class EventManagerService :  EventManager{

    override fun findRoom(requestRoom: RequestRoom, available: List<RoomModel>): RoomModel {
        return available.firstOrNull { room ->
            room.maxCapacity >= requestRoom.guestsQuantity &&
                    room.roomType == requestRoom.roomType &&
                    room.equipmentModels.containsAll(listOf(requestRoom.desiredEquipmentModel))
        } ?: throw IllegalStateException("Не найдено ни одной подходящей комнаты")
    }

    override fun createBooking(roomModel: RoomModel, nameGuest: String): InvoiceModel {
        TODO("Not yet implemented")
    }


}