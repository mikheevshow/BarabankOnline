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

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_number_generator")
    @SequenceGenerator(name = "account_number_generator", sequenceName = "account_number_sequence")
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "customer", nullable = false)
    private Customer customer;

    @Column(name = "balance", nullable = false)
    private BigDecimal sum;

    public Account() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", customer=" + customer +
                ", sum=" + sum +
                '}';
    }
}
