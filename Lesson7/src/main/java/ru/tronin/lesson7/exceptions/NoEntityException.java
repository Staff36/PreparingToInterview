package ru.tronin.lesson7.exceptions;

public class NoEntityException extends RuntimeException {
    public NoEntityException(String message) {
        super(message);
    }
}
