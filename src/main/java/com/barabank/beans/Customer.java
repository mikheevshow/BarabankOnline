package com.barabank.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * @author Ilya Mikheev
 * @author Leonid Zemenkov
 */

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_generator")
    @SequenceGenerator(name = "customer_id_generator", sequenceName = "customer_id_sequence")
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "phone", nullable = false, unique = true, updatable = false, insertable = false)
    private long phone;

    @Column(name = "password",nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
    private List<Account> accounts = new ArrayList<Account>();

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "phone", referencedColumnName = "phone")
    private Person person;

    public Customer() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        account.setCustomer(this);
        getAccounts().add(account);
    }

    public void removeAccount(Account account) {
        getAccounts().remove(account);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", phone=" + phone +
                ", password='" + password +
                '}';
    }
}
