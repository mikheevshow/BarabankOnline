package com.barabank.dao;

import com.barabank.service.enums.TransactionReportType;
import com.barabank.service.logic.BarabankTransactionReportService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.time.LocalDate;

public class hello {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("application-context.xml");
        BankDao bankDao = context.getBean("barabankDao", BankDao.class);
        BarabankTransactionReportService barabankTransactionReportService = context.getBean("barabankTransactionReportService", BarabankTransactionReportService.class);
        LocalDate localDate = LocalDate.of(2018,9, 13);
        System.out.println(barabankTransactionReportService.getTransactionsForAccountInDate(2313L, localDate, TransactionReportType.JSON));
        //Transaction transaction = new Transaction();

//        transaction.setFromAccount(663636L);
//        transaction.setToAccount(2313L);
//
//        BigDecimal bigDecimal = BigDecimal.valueOf(23632L);
//        transaction.setSum(bigDecimal);
//        transaction.setDate(OffsetDateTime.now());
//
//        System.out.println(transaction.toString());
//
//
//        bankDao.saveTransaction(transaction);
//
//        List<Transaction> list = bankDao.findAllSentAccountTransactions(2323L);
//
//        for (Transaction transaction1:list) {
//            System.out.println(transaction1.toString());
//        }

//
//        Person person = new Person();
//        person.setFirstName("Ilya");
//        person.setMiddleName("Dmitrievich");
//        person.setLastName("Mikheev");
//        person.setAddress("Reutov, Pobedy 2-46");
//        person.setId(123456789L);
//        person.setPhone(79999999999L);
//        person.setBirthDate(LocalDate.of(1995, 8,2 ));
//
//        Customer customer = new Customer();
//
//        customer.setId(person.getPhone());
//
//        customer.setPassword("1Mikheypop");
//
//        person.setCustomer(customer);
//
//        //bankDao.saveCustomer(customer);
//
//        bankDao.savePerson(person);


    }
}
