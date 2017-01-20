package ru.livetex.exceptions;

/**
 * Created by sergey on 1/19/17.
 */
public class RoomClosedException extends Exception {
    public RoomClosedException() {
        super("Cannot make actions with room because of its closed");
    }
}
