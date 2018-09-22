package com.barabank.dao;

import com.barabank.beans.Account;
import com.barabank.beans.Customer;
import com.barabank.beans.Person;
import com.barabank.beans.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class hello {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("application-context.xml");
        BankDao bankDao = context.getBean("barabankDao", BankDao.class);

//        Customer customer = new Customer();
//        customer.setPhone(1234);
//        customer.setPassword("asdf");
//
//        Person person = new Person();
//        person.setCustomer(customer);
//        person.setPassportId(456789);
//        person.setFirstName("Нитика");
//        person.setLastName("Изотов");
//        person.setMiddleName("Владимирович");
//        person.setAddress("Москва");
//        person.setBirthDate(LocalDate.now().minusYears(22));
//
//        customer.setPerson(person);
//
//        bankDao.saveCustomer(customer);

//        Customer as = bankDao.findCustomerByPhone(1234);
//
//        System.out.println(as.toString());
//        System.out.println(as.getPerson().toString());

        Person person = bankDao.findPersonByPhone(1234);

        System.out.println(person);
        System.out.println(person.getCustomer());
    }
}
