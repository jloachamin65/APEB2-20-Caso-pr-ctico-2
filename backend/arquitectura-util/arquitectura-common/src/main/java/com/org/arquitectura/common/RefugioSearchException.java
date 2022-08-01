package com.org.arquitectura.common;

public class RefugioSearchException extends Exception {

    public RefugioSearchException() {
    }

    public RefugioSearchException(String message) {
        super(message);
    }

    public RefugioSearchException(String message, Throwable cause) {
        super(message, cause);
    }

    public RefugioSearchException(Throwable cause) {
        super(cause);
    }

    public RefugioSearchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
