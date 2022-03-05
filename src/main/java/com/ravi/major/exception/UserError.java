package com.ravi.major.exception;

public class UserError {

    private String message;

    public UserError() {
    }

    public UserError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
