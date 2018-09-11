package com.barabank.beans;


import org.joda.time.LocalDate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * @author Ilya Mikheev
 *
 */

@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

    private long id;
    private long fromAccount;
    private long toAccount;
    private BigDecimal sum;
    private LocalDate date;

    public Transaction() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "from_account")
    public long getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(long fromAccount) {
        this.fromAccount = fromAccount;
    }

    @Column(name = "to_account")
    public long getToAccount() {
        return toAccount;
    }

    public void setToAccount(long toAccount) {
        this.toAccount = toAccount;
    }

    @Column(name = "sum")
    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

//    @Temporal(value = TemporalType.TIMESTAMP)
//    @Column(name = "date")
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
}
