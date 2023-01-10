package dev.luanfernandes.cars.api.exceptions;

import java.io.Serial;

public class ConvertException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 6521431602236773261L;

    public ConvertException(String message) {
        super(message);
    }
}
