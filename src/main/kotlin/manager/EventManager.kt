package manager

import enums.EquipmentType
import enums.RoomType
import pojo.EquipmentModel
import pojo.InvoiceModel
import pojo.RequestRoom
import pojo.RoomModel

interface EventManager {

    fun findRoom(requestRoom: RequestRoom, available: List<RoomModel>): RoomModel

    fun createBooking(roomModel: RoomModel, nameGuest: String) : InvoiceModel

}