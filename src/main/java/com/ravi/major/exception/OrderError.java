package com.ravi.major.exception;

public class OrderError {

    private String ErrorMessage;

    public OrderError() {
    }

    public OrderError(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }
}
