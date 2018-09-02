package com.barabank.beans;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

    private BigInteger id;
    private BigInteger fromAccount;
    private BigInteger toAccount;
    private BigInteger sum;
    private Date date;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Column(name = "from_account")
    public BigInteger getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(BigInteger fromAccount) {
        this.fromAccount = fromAccount;
    }

    @Column(name = "to_account")
    public BigInteger getToAccount() {
        return toAccount;
    }

    public void setToAccount(BigInteger toAccount) {
        this.toAccount = toAccount;
    }

    @Column(name = "sum")
    public BigInteger getSum() {
        return sum;
    }

    public void setSum(BigInteger sum) {
        this.sum = sum;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
