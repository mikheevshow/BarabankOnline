package com.barabank.service.exceptions;

public class AccountNumberExeption extends Exception {
    Exception e;
    public AccountNumberExeption(String message, Exception e) {
        super(message);
        this.e =e;
    }

    public AccountNumberExeption(String message) {
        super(message);
    }
}
