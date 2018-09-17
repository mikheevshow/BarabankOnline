package com.barabank.beans;

import antlr.collections.impl.LList;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * @author Ilya Mikheev
 * @author Leonid Zemenkov
 */

@Entity
@Table(name = "customer",schema = "public")
public class Customer implements Serializable {

    @Id
    @SequenceGenerator(name = "customer_id_seq", sequenceName = "customer_id_seq", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_id_seq")
    @Column(name = "customer_id")
    private long customerId;


    @Column(name = "phone")
    private long phone;

    @Column(name = "password",nullable = false)
    private String password;


    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    private Person person;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Account> accounts = new LinkedList<>();

    public Customer() {

    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "phone=" + phone +
                ", password='" + password + '\'' +
                '}';
    }
}
