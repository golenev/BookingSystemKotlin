package services

import interfaces.EventManager
import models.InvoiceModel
import models.RequestRoom
import models.RoomModel
import util.FileUtils

class EventManagerService : EventManager {


    override fun findRoom(requestRoom: RequestRoom, available: List<RoomModel>): RoomModel {
        print("Ищем в базе комнату с параметрами $requestRoom")
        return available.firstOrNull {
            it.maxCapacity >= requestRoom.guestsQuantity &&
                    it.roomType == requestRoom.roomType &&
                    it.equipmentModel.equipmentType == requestRoom.desiredEquipmentModel.equipmentType
            it.equipmentModel.quantity >= requestRoom.desiredEquipmentModel.quantity
        } ?: throw IllegalStateException("Не найдено ни одной подходящей комнаты")
    }

    /**
     * Метод для отправки в базу одного объекта.
     * Принимает на вход Any, но кастить ничего не надо, всё законно
     */
    override fun createBooking(roomModel: InvoiceModel, tableName: String) {
        FileUtils().saveObjectAsJson(roomModel, tableName)
    }

    /**
     * Заполняем таблицу сущностей переговорок в воображаемой БД
     */
    fun <T> insertEntitiesToDataBase(listObj: List<T>,tableName: String) {
        FileUtils().saveObjectAsJson(listObj, tableName)
    }

    /**
     * Передаём на вход желаемую комнату и список комнат.
     * И ищем желаемую среди всего списка.
     * Если нашли, возвращаем комнату
     */
    fun lookForRequiredRoom(roomEntitiesTable : List<RoomModel>, requestRoom: RequestRoom) : InvoiceModel {
        val result = findRoom(requestRoom, roomEntitiesTable)
        return InvoiceModel(result, requestRoom.clientName)
    }

    /**
     * В цикле созадём коллекцию комнат и возвращаем её
     */
    fun buildRoomsCollection(): MutableList<RoomModel> {
        val rooms = mutableListOf<RoomModel>()
        for (i in 1..100) {
            val room = RoomBuilderService().generateOneRoom()
            rooms.add(room)
        }
        return rooms
    }


}