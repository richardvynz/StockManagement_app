package com.richardvynz.StockManager_Application.exception;

import lombok.Getter;

@Getter
public class StockUnAvailableException extends RuntimeException {

    private String errorCode;
    public StockUnAvailableException(String message,String errorCode) {
        super(message);
        this.errorCode=errorCode;
    }
}
