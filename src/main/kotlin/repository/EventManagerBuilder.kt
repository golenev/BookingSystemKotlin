package repository

import enums.EquipmentType
import enums.RoomType
import manager.EventManager
import pojo.InvoiceModel
import pojo.RoomModel

class EventManagerBuilder :  EventManager{
    override fun findRoom(guestsQuantity: Int, roomType: RoomType, equipmentType: EquipmentType, roomList: List<RoomModel>): RoomModel {

        val room = RoomModel( guestsQuantity,  roomType, equipmentType)
        return roomList.find { it.guestsQuantity == room.maxCapacity && it.roomType == room.roomType && it.equipmentType == room.equipmentType }

    }

    override fun createBooking(roomModel: RoomModel, nameGuest: String): InvoiceModel {
        TODO("Not yet implemented")
    }
}