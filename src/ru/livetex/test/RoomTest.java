package ru.livetex.test;

import org.junit.Test;
import ru.livetex.exceptions.EmptyRoomException;
import ru.livetex.exceptions.RoomClosedException;
import ru.livetex.exceptions.RoomAlreadyHasObjectException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RoomTest extends ru.livetex.test.Test {
    @Test
    public void roomIsClosedByDefault() {
        assertTrue(!room.isOpen());
    }

    @Test(expected = RoomClosedException.class)
    public void roomIsEmptyByDefault() throws EmptyRoomException, RoomClosedException {
        assertTrue(room.isEmpty());
    }

    @Test
    public void roomIsEmptyByDefaultAfterOpening() throws EmptyRoomException, RoomClosedException {
        room.open();
        assertTrue(room.isEmpty());
    }

    @Test
    public void canCloseOpenedRoom() throws EmptyRoomException, RoomClosedException {
        room.open();
        room.close();
    }

    // Add Object

    @Test(expected = RoomClosedException.class)
    public void addObjectToClosedRoom() throws RoomAlreadyHasObjectException, RoomClosedException {
        room.addObject(firstObject);
    }

    @Test
    public void addFirstObjectToEmptyOpenedRoom() throws RoomAlreadyHasObjectException, RoomClosedException, EmptyRoomException {
        room.open();
        room.addObject(firstObject);
        assertEquals(room.getObject(), firstObject);
    }

    @Test(expected = RoomAlreadyHasObjectException.class)
    public void addFirstObjectToFilledOpenedRoom() throws RoomAlreadyHasObjectException, RoomClosedException, EmptyRoomException {
        addFirstObjectToEmptyOpenedRoom();
        room.addObject(firstObject);
    }

    @Test(expected = RoomClosedException.class)
    public void addFirstObjectToFilledClosedRoom() throws RoomAlreadyHasObjectException, RoomClosedException, EmptyRoomException {
        addFirstObjectToEmptyOpenedRoom();
        room.close();
        room.addObject(firstObject);
    }

    @Test(expected = RoomAlreadyHasObjectException.class)
    public void addSecondObjectToFilledOpenedRoom() throws RoomAlreadyHasObjectException, RoomClosedException, EmptyRoomException {
        addFirstObjectToEmptyOpenedRoom();
        room.addObject(secondObject);
    }

    // Remove Object

    @Test
    public void removeObjectFromFilledOpenedRoom() throws RoomClosedException, EmptyRoomException, RoomAlreadyHasObjectException {
        addFirstObjectToEmptyOpenedRoom();
        room.removeObject();
        assertTrue(room.isEmpty());
    }

    @Test(expected = RoomClosedException.class)
    public void removeObjectFromEmptyClosedRoom() throws RoomAlreadyHasObjectException, RoomClosedException {
        room.removeObject();
    }

    @Test(expected = RoomClosedException.class)
    public void removeObjectFromFilledClosedRoom() throws RoomAlreadyHasObjectException, RoomClosedException {
        room.addObject(firstObject);
        room.close();
        room.removeObject();
    }

    @Test
    public void removeObjectFromEmptyOpenedRoom() throws RoomClosedException, EmptyRoomException, RoomAlreadyHasObjectException {
        room.open();
        room.removeObject();
        assertTrue(room.isEmpty());
    }

    // Get Object

    @Test(expected = RoomClosedException.class)
    public void getObjectFromEmptyClosedRoom() throws EmptyRoomException, RoomClosedException {
        room.getObject();
    }

    @Test(expected = EmptyRoomException.class)
    public void getObjectFromEmptyOpenedRoom() throws EmptyRoomException, RoomClosedException {
        room.open();
        room.getObject();
    }

    @Test(expected = RoomClosedException.class)
    public void getObjectFromFilledClosedRoom() throws EmptyRoomException, RoomClosedException, RoomAlreadyHasObjectException {
        addFirstObjectToEmptyOpenedRoom();
        room.close();
        room.getObject();
    }

    @Test
    public void getObjectFromFilledOpenedRoom() throws EmptyRoomException, RoomClosedException, RoomAlreadyHasObjectException {
        addFirstObjectToEmptyOpenedRoom();
        assertEquals(room.getObject(), firstObject);
    }

    // End to end

    @Test
    public void removeFirstAndAddSecondObject() throws EmptyRoomException, RoomClosedException, RoomAlreadyHasObjectException {
        addFirstObjectToEmptyOpenedRoom();
        room.removeObject();
        room.addObject(secondObject);
        assertEquals(room.getObject(), secondObject);
    }


}