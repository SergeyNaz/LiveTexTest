package ru.livetex;

import ru.livetex.exceptions.EmptyRoomException;
import ru.livetex.exceptions.RoomAlreadyHasObjectException;
import ru.livetex.exceptions.RoomClosedException;

public class Room {
    private boolean isOpen = false;
    private Object objectInRoom;
    private EventListener eventListener;

    public boolean isOpen() {
        return isOpen;
    }

    public void open() {
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }

    public boolean isEmpty() throws RoomClosedException {
        if (!isOpen) {
            throw new RoomClosedException();
        }
        return objectInRoom == null;
    }

    public Object getObject() throws RoomClosedException, EmptyRoomException {
        if (!isOpen) {
            throw new RoomClosedException();
        }
        if (objectInRoom == null) {
            throw new EmptyRoomException();
        }
        return objectInRoom;
    }

    public void addObject(Object object) throws RoomClosedException, RoomAlreadyHasObjectException {
        if (!isOpen) {
            throw new RoomClosedException();
        }
        if (objectInRoom != null) {
            throw new RoomAlreadyHasObjectException();
        }
        if (eventListener != null) {
            eventListener.onObjectInRoom(object);
        }
        objectInRoom = object;
    }

    public void removeObject() throws RoomClosedException {
        if (!isOpen) {
            throw new RoomClosedException();
        }
        if (objectInRoom != null) {
            objectInRoom = null;
        }
    }

    public void subscribe(EventListener eventListener) {
        this.eventListener = eventListener;
    }

}
