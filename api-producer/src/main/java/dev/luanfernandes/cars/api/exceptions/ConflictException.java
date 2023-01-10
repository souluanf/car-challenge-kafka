package dev.luanfernandes.cars.api.exceptions;

import java.io.Serial;

public class ConflictException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 7144425063406092880L;

    public ConflictException(String message) {
        super(message);
    }
}
