package com.barabank.dao;

import com.barabank.beans.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

public class hello {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("application-context.xml");
        BankDao bankDao = context.getBean("barabankDao", BankDao.class);
        Transaction transaction = new Transaction();

        transaction.setFromAccount(663636L);
        transaction.setToAccount(2313L);

        BigDecimal bigDecimal = BigDecimal.valueOf(23632L);
        transaction.setSum(bigDecimal);
        transaction.setDate(OffsetDateTime.now());

        System.out.println(transaction.toString());


        bankDao.saveTransaction(transaction);

        List<Transaction> list = bankDao.findAllSentAccountTransactions(2323L);

        for (Transaction transaction1:list) {
            System.out.println(transaction1.toString());
        }



    }
}
