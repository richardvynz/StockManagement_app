package com.richardvynz.StockManager_Application.exception;

import lombok.Getter;

@Getter
public class StockAlreadyExistException extends RuntimeException{

    private String errorCode;

    public StockAlreadyExistException(String message, String error){
        super(message);
        this.errorCode = error;
    }
}
