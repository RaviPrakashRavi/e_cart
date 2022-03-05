package com.ravi.major.exception;

public class NoItemSelected extends RuntimeException{
    public NoItemSelected(String message) {
        super(message);
    }

    public NoItemSelected(String message, Throwable cause) {
        super(message, cause);
    }
}
