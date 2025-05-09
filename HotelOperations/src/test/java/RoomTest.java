import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class RoomTest {

    @Test
    void checkIn() {
        Room room = new Room(2, 100.00, false, false);

        room.checkIn();

        boolean actualOccupied = room.isOccupied();
        boolean actualDirty = room.isDirty();


        Assertions.assertTrue(actualOccupied);
        Assertions.assertTrue(actualDirty);
        Assertions.assertFalse(room.canClean());
    }

    @Test
    void checkOut() {
        Room room = new Room(2, 100.00, true, true);

        room.checkOut();

        boolean actualOccupied = room.isOccupied();
        boolean actualDirty = room.isDirty();

        Assertions.assertTrue(actualDirty);
        Assertions.assertFalse(actualOccupied);

    }

    @Test
    void cleanRoom() {

    }
}