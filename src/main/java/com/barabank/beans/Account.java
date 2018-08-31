package com.barabank.beans;


import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "account")
public class Account implements Serializable {

    private long id;
    private long customer;
    private BigDecimal sum;

    public Account() {

    }

    public Account(long id, long customer, BigDecimal sum) {
        this.id = id;
        this.customer = customer;
        this.sum = sum;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //Тут нужен генератор
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne
    @Column(name = "customer")
    public long getCustomer() {
        return customer;
    }

    public void setCustomer(long customer) {
        this.customer = customer;
    }

    @Column(name = "sum")
    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
