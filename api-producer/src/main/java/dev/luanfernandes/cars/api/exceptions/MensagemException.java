package dev.luanfernandes.cars.api.exceptions;

import java.io.Serial;

public class MensagemException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = -3459853345996458416L;

	public MensagemException(String message) {
		super(message);
	}
}