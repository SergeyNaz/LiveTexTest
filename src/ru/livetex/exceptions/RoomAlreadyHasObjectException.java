package ru.livetex.exceptions;

/**
 * Created by sergey on 1/19/17.
 */
public class RoomAlreadyHasObjectException extends Exception {
    public RoomAlreadyHasObjectException() {
        super("Cannot add new object to the room when it already has an object");
    }
}

