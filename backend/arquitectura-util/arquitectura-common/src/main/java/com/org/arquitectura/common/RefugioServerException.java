package com.org.arquitectura.common;

public class RefugioServerException extends Exception {
    public RefugioServerException() {
    }

    public RefugioServerException(String message) {
        super(message);
    }

    public RefugioServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public RefugioServerException(Throwable cause) {
        super(cause);
    }
}
