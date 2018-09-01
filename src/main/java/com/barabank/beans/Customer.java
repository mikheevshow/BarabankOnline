package com.barabank.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private long id;
    private long phone;
    private String password;
   // private List<Account> accounts = new ArrayList<Account>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Column(name = "phone")
    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//   // @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//   // public List<Account> getAccounts() {
//        return accounts;
//    }

//    public void setAccounts(List<Account> accounts) {
//        this.accounts = accounts;
//    }
//
//    public void addAccount(Account account) {
//        account.setCustomer(this);
//        getAccounts().add(account);
//
//    }
//
//    public void removeAccount(Account account) {
//        getAccounts().remove(account);
//    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", phone=" + phone +
                ", password='" + password +
                '}';
    }
}
