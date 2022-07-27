package ru.kpfu.itis.genatulin.hw5.exceptions;

public class PersonDoesNotExistException extends Exception {
    public PersonDoesNotExistException(String message) {
        super(message);
    }
}
