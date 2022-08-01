package com.org.arquitectura.common;

public class RefugioProcessException extends Exception {

    public RefugioProcessException() {
    }

    public RefugioProcessException(String message) {
        super(message);
    }

    public RefugioProcessException(String message, Throwable cause) {
        super(message, cause);
    }

    public RefugioProcessException(Throwable cause) {
        super(cause);
    }

    public RefugioProcessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

