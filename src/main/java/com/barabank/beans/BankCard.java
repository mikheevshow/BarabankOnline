package com.barabank.beans;

import com.barabank.service.enums.BankCardPaymentSystem;

import java.io.Serializable;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Ilya Mikheev
 * @author Leonid Zemenkov
 */

@Entity
@Table(name = "bank_card",schema = "public")
public class BankCard implements Serializable {

    @SequenceGenerator(name = "bankcard_id_seq",sequenceName = "bankcard_id_seq",allocationSize = 20)

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bankcard_id_seq")
    @Column(name = "card_number", nullable = false, unique = true, updatable = false)
    private long cardNumber;

    @Column(name = "security_code", nullable = false, updatable = false)
    private int securityCode;

    @Column(name = "pin", nullable = false)
    private int pin;

    @Column(name = "expiration_date", nullable = false, updatable = false)
    private LocalDateTime expirationDate;

    @Enumerated(EnumType.STRING)
    private BankCardPaymentSystem paymentSystem;


    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public BankCard() {

    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
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

    public BankCardPaymentSystem getPaymentSystem() {
        return paymentSystem;
    }

    public void setPaymentSystem(BankCardPaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
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
