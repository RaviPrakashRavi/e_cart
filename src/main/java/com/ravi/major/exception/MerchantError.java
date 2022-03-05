package com.ravi.major.exception;

public class MerchantError {

    private String errorMessage;

    public MerchantError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
