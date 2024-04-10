package manager

import enums.EquipmentType
import enums.RoomType
import pojo.InvoiceModel
import pojo.RoomModel

interface EventManager {

    fun findRoom(guestsQuantity: Int, roomType: RoomType, equipmentType: EquipmentType, roomList: List<RoomModel>): RoomModel

    fun createBooking(roomModel: RoomModel, nameGuest: String) : InvoiceModel

}