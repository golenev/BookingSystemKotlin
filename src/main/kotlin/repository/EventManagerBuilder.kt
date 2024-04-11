package repository

import manager.EventManager
import pojo.InvoiceModel
import pojo.RequestRoom
import pojo.RoomModel

class EventManagerBuilder :  EventManager{

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