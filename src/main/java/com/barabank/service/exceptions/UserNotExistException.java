package com.barabank.service.exceptions;

import javax.persistence.NoResultException;

public class UserNotExistException extends NoResultException {
    private Exception exception;

    public UserNotExistException(String message,Exception exception) {
        super(message);
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }

}
