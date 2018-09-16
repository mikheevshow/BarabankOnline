package com.barabank.dao;

import com.barabank.beans.Customer;
import com.barabank.beans.Person;
import com.barabank.beans.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class hello {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("application-context.xml");
        BankDao bankDao = context.getBean("barabankDao", BankDao.class);


//        Customer customer = new Customer();
//        customer.setPhone(54L);
//        customer.setPassword("rgwenrncoeiqpr");
//
//        customer = bankDao.saveCustomer(customer);
//
//        Person person = new Person();
//        LocalDate localDate = LocalDate.of(1111, 11, 1);
//        person.setPassportId(123421L);
//        person.setAddress("sdng");
//        person.setFirstName("Ivan");
//        person.setLastName("Ivanov");
//        person.setMiddleName("Ivanovih");
//        person.setBirthDate(localDate);
//        person.setCustomer(customer);
//
//        person = bankDao.savePerson(person);
//
//
//        System.out.println("HERE");
//
//        for (int i = 0; i < 10; i++) {
//            bankDao.addAccountForCustomer(customer);
//        }

//
//        Person person = bankDao.findPersonWithPassportID(123421L);
//
//        System.out.println(person.toString());
//
//        person.setLastName("Zemenkov");
//        bankDao.updatePerson(person);
//
//        System.out.println(person.toString());
//
//        for (int i=342;i<=351;i++){
//            for(int j=342;j<=351;j++) {
//                Transaction transaction = new Transaction();
//                if(i!=j) {
//                    transaction.setFromAccount(i);
//                    transaction.setToAccount(j);
//                    transaction.setDate(LocalDateTime.now());
//                    transaction.setSum(BigDecimal.valueOf((long)i+j));
//                    bankDao.saveTransaction(transaction);
//                }
//            }
//        }
//
//
//        LocalDate today = LocalDate.now().minusDays(1);
//
//        List<Transaction> transactions = bankDao.getBankTransactionsForDay(today);
//
//
//        System.out.println("////////////////////////////////////////////////");
//        for (Transaction transaction : transactions) {
//            System.out.println(transaction.toString());
//        }




    Customer customer = new Customer();
    customer.setPhone(12345L);
    customer.setPassword("yterfwd");

        Person person = new Person();
        person.setPassportId(54321L);
        person.setFirstName("dfwe");
        person.setLastName("sdaff");
        person.setMiddleName("dsfgw");
        person.setBirthDate(LocalDate.of(2000, 1, 1));
        person.setPhone(12345L);
        person.setAddress("asfasdf");

        person.setCustomer(customer);
        customer.setPerson(person);


        bankDao.saveCustomer(customer);

    }
}
