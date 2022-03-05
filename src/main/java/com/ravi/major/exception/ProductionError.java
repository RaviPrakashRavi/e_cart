package com.ravi.major.exception;

import java.util.Date;

public class ProductionError {

    private String message;

    public ProductionError(String message) {
        this.message = message;
    }




    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
