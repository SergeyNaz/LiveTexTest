package ru.livetex.test;

import org.junit.Before;
import ru.livetex.EventListener;
import ru.livetex.Room;

public class Test {
    protected Room room;
    protected Object firstObject;
    protected Object secondObject;
    protected EventListener eventListener;

    @Before
    public void setUp() {
        room = new Room();
        firstObject = new Object();
        secondObject = new Object();
        eventListener = new EventListener();
    }

}
