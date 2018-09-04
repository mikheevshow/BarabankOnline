package com.barabank.beans;


import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * @author Ilya Mikheev
 *
 */

@Entity
@Table(name = "account")
public class Account implements Serializable {

    private long id;
    private Customer customer;
    private BigDecimal sum;

    public Account() {

    }

    public Account(long id, Customer customer, BigDecimal sum) {
        this.id = id;
        this.customer = customer;
        this.sum = sum;
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

   @ManyToOne
   @JoinColumn(name = "customer")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Column(name = "sum")
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
