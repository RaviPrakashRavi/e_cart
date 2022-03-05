package com.ravi.major.exception;

public class MerchantException extends RuntimeException{

    public MerchantException() {
    }

    public MerchantException(String message) {
        super(message);
    }

    public MerchantException(String message, Throwable cause) {
        super(message, cause);
    }
}
