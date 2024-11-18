package com.krakedev.inventarios.exceptions;

public class KrakeDevException extends Exception {
	public KrakeDevException(String mensaje) {
		super(mensaje);
	}
	public KrakeDevException(String message, Throwable cause) {
        super(message, cause);
    }
}
