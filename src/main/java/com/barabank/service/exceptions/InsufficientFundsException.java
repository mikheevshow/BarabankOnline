package com.barabank.service.exceptions;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message){
        super(message);
    }

}
