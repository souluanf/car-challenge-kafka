package dev.luanfernandes.cars.api.exceptions;

import java.io.Serial;

public class ServerException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 6182568462459725689L;

    public ServerException(String msg) {
        super(msg);
    }
}