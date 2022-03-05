package com.ravi.major.exception;

public class ItemError {

    private String ErrorMessage;

    public ItemError() {
    }

    public ItemError(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }
}
