package dev.luanfernandes.cars.api.exceptions;

import java.io.Serial;

public class NotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -1014067657663477267L;

    public NotFoundException(Long id, Object obj) {
        super(String.format("O %s com id : %s nao foi encontrado",id, obj.getClass().getSimpleName().toLowerCase()));
    }

    public NotFoundException(String email, Object obj) {
        super(String.format("O %s com email : %s nao foi encontrado",email, obj.getClass().getSimpleName().toLowerCase()));
    }
}