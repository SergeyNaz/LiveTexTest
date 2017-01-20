package ru.livetex.test;

import org.junit.Assert;
import org.junit.Test;
import ru.livetex.exceptions.RoomAlreadyHasObjectException;
import ru.livetex.exceptions.RoomClosedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class EventListenerTest extends ru.livetex.test.Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void addObjectToRoom() throws RoomAlreadyHasObjectException, RoomClosedException {
        System.setOut(new PrintStream(outContent));
        room.open();
        room.addObject(firstObject);
        Assert.assertEquals("", outContent.toString());
    }

    @Test
    public void subscribeAndAddObjectToRoom() throws RoomAlreadyHasObjectException, RoomClosedException {
        System.setOut(new PrintStream(outContent));
        room.subscribe(eventListener);
        room.open();
        room.addObject(firstObject);
        Assert.assertEquals("Object was added to the room", outContent.toString());
    }

}
