package com.barabank.beans;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Ilya Mikheev
 * @author Leonid Zemenkov
 */

@Entity
@Table(name = "person",schema = "public")
public class Person implements Serializable {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "customer_id", nullable = false, unique = true,
            updatable = false,insertable = false)
    private long customerId;

    @Id
    @Column(name = "passport_id",nullable = false, unique = true)
    private long passportId;

    @Column(name = "address", nullable = false)
    private String  address;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

   @OneToOne
   @JoinColumn(name = "customer_id")
   private Customer customer;

    public Person() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getPassportId() {
        return passportId;
    }

    public void setPassportId(long personId) {
        this.passportId = personId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", customerId=" + customerId +
                ", personId=" + passportId +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}

