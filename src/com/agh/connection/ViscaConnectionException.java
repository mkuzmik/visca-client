package com.agh.connection;

public class ViscaConnectionException extends RuntimeException {

    public ViscaConnectionException(String message) {
        super(message);
    }

    public ViscaConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
