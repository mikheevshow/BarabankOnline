package com.barabank.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Ilya Mikheev
 * @author Leonid Zemenkov
 */


@Entity
@Table(name = "account")
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

    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + accountId +
                ", customer._id=" + customer.getCustomerId() +
                ", sum=" + balance +
                '}';
    }
}
