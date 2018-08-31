//package com.barabank.beans;
//
//import java.io.Serializable;
//import java.sql.Date;
//
//import javax.persistence.*;
//
//
//@Entity
//@Table(name = "bank_card")
//public class BankCard implements Serializable {
//
//    private long cardNumber;
//    private long account;
//    private int securityCode;
//    private int pin;
//    private Date expirationDate;
//
//    @Id
//    @Column(name = "card_number")
//    public long getCardNumber() {
//        return cardNumber;
//    }
//
//    public void setCardNumber(long cardNumber) {
//        this.cardNumber = cardNumber;
//    }
//
//    @ManyToOne
//    @Column(name = "account")
//    public long getAccount() {
//        return account;
//    }
//
//    public void setAccount(long account) {
//        this.account = account;
//    }
//
//    @Column(name = "secutity_code")
//    public int getSecurityCode() {
//        return securityCode;
//    }
//
//    public void setSecurityCode(int securityCode) {
//        this.securityCode = securityCode;
//    }
//
//    @Column(name = "pin")
//    public int getPin() {
//        return pin;
//    }
//
//    public void setPin(int pin) {
//        this.pin = pin;
//    }
//
//    @Column(name = "expiration_date")
//    public Date getExpirationDate() {
//        return expirationDate;
//    }
//
//    public void setExpirationDate(Date expirationDate) {
//        this.expirationDate = expirationDate;
//    }
//
//    @Override
//    public String toString() {
//        return "BankCard{" +
//                "cardNumber=" + cardNumber +
//                ", account=" + account +
//                ", securityCode=" + securityCode +
//                ", pin=" + pin +
//                ", expirationDate=" + expirationDate +
//                '}';
//    }
//}
