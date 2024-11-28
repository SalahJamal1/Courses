package com.example.demo.exception;


public class ErrorNotFoundException extends RuntimeException {
    public ErrorNotFoundException(String message) {
        super(message);
    }

    public ErrorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorNotFoundException(Throwable cause) {
        super(cause);
    }
}
