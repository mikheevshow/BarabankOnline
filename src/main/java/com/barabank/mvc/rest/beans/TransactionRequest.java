package com.barabank.mvc.rest.beans;

import com.barabank.beans.Transaction;
import com.barabank.mvc.rest.Enumerators.TransactionType;

import java.io.Serializable;
import java.math.BigDecimal;

public class TransactionRequest implements Serializable {
    private long fromAccount;
    private long toAccount;
    private BigDecimal sum;
    private TransactionType type;

    public TransactionRequest() {
    }

    public long getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(long fromAccount) {
        this.fromAccount = fromAccount;
    }

    public long getToAccount() {
        return toAccount;
    }

    public void setToAccount(long toAccount) {
        this.toAccount = toAccount;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TransactionRequest{" +
                "fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                ", sum=" + sum +
                ", type=" + type +
                '}';
    }
}
