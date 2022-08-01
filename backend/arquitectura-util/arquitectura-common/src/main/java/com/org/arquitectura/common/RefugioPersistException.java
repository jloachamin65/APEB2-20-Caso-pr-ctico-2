package com.org.arquitectura.common;

public class RefugioPersistException extends Exception {

    public RefugioPersistException() {
    }

    public RefugioPersistException(String message) {
        super(message);
    }

    public RefugioPersistException(String message, Throwable cause) {
        super(message, cause);
    }

    public RefugioPersistException(Throwable cause) {
        super(cause);
    }

    public RefugioPersistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
