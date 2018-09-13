package com.barabank.beans;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Ilya Mikheev
 * @author Leonid Zemenkov
 */

@Entity
@Table(name = "bank_card")
public class BankCard implements Serializable {

    @Id
    @Column(name = "card_number", nullable = false, unique = true, updatable = false)
    private long cardNumber;

    @Column(name = "account", nullable = false, updatable = false)
    private long account;

    @Column(name = "security_code", nullable = false, updatable = false)
    private int securityCode;

    @Column(name = "pin", nullable = false)
    private int pin;

    @Column(name = "expiration_date", nullable = false, updatable = false)
    private LocalDateTime expirationDate;

    public BankCard() {

    }

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

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "cardNumber=" + cardNumber +
                ", account=" + account +
                ", securityCode=" + securityCode +
                ", pin=" + pin +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
