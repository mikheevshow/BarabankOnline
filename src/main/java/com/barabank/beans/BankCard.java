package com.barabank.beans;

import org.joda.time.LocalDate;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "bank_card")
public class BankCard {

    private long cardNumber;
    private long account;
    private int securityCode;
    private int pin;
    private Date expirationDate;

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
