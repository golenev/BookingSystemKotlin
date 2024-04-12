import controller.MeetingRoomGenerator
import org.junit.jupiter.api.Test

class BookingTest {

    @Test
    fun test() {
        MeetingRoomGenerator().writeRoomsToJson();
      val reqRoom =  MeetingRoomGenerator().lookForRequiredRoom()
    }

}