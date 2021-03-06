package com.barabank.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author Ilya Mikheev
 * @author Leonid Zemenkov
 */


@Entity
@Table(name = "account",schema = "public")
public class Account implements Serializable {

    @SequenceGenerator(name = "account_id_seq",
                        sequenceName = "account_id_seq",
                        allocationSize = 20)


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id_seq")
    @Column(name = "account_id", unique = true, nullable = false)
    private long accountId;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance = BigDecimal.valueOf(0L);

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "customer_id",insertable = false, updatable = false)
    private long customerId;

    @OneToMany(mappedBy = "account")
    private List<BankCard> bankCardSet = new ArrayList<>();



    public Account() {

    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal sum) {
        this.balance = sum;
    }

    public void addBankCards(Collection<? extends BankCard> collection){
        bankCardSet.addAll(collection);

    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public List<BankCard> getBankCardSet() {
        return bankCardSet;
    }

    public void setBankCardSet(List<BankCard> bankCardSet) {
        this.bankCardSet = bankCardSet;
    }


    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + accountId +
                ", customer_id=" + customerId +
                ", sum=" + balance +
                '}';
    }
}
