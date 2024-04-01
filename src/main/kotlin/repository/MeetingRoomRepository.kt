package repository

import pojo.BookingModel
import util.JsonReader

class MeetingRoomRepository {

    fun getMeetingRooms () : List<BookingModel> {
     return listOf(
         JsonReader().objectifyJson("room1.json"),
         JsonReader().objectifyJson("room2.json"),
         JsonReader().objectifyJson("room3.json"))
    }

}