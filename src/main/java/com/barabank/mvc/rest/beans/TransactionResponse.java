package com.barabank.mvc.rest.beans;

import com.barabank.mvc.rest.Enumerators.TransactionStatus;

import java.io.Serializable;

public class TransactionResponse implements Serializable {
    private TransactionStatus transactionStatus;
    private String message;

    public TransactionResponse() {
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "transactionStatus=" + transactionStatus +
                ", message='" + message + '\'' +
                '}';
    }
}
