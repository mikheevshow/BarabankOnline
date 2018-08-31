//package com.barabank.beans;
//
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.sql.Date;
//
//@Entity
//@Table(name = "transaction")
//public class Transaction implements Serializable {
//
//    private long id;
//    private long fromAccount;
//    private long toAccount;
//    private double sum;
//    private Date date;
//
//    @Id
//    @GeneratedValue()
//    @Column(name = "id")
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    @Column(name = "from_account")
//    public long getFromAccount() {
//        return fromAccount;
//    }
//
//    public void setFromAccount(long fromAccount) {
//        this.fromAccount = fromAccount;
//    }
//
//    @Column(name = "to_account")
//    public long getToAccount() {
//        return toAccount;
//    }
//
//    public void setToLong(long toAccount) {
//        this.toAccount = toAccount;
//    }
//
//    @Column(name = "sum")
//    public double getSum() {
//        return sum;
//    }
//
//    public void setSum(double sum) {
//        this.sum = sum;
//    }
//
//    @Column(name = "date")
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//}
