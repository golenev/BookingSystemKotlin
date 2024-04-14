package interfaces

import models.InvoiceModel
import models.RequestRoom
import models.RoomModel

interface EventManager {
    fun findRoom(requestRoom: RequestRoom, available: List<RoomModel>): RoomModel
    fun createBooking(roomModel: InvoiceModel, tableName: String)
}