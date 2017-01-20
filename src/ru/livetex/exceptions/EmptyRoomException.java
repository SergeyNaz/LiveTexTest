package ru.livetex.exceptions;

/**
 * Created by sergey on 1/19/17.
 */
public class EmptyRoomException extends Exception {
    public EmptyRoomException() {
        super("Cannot get object because of room is empty");
    }
}
