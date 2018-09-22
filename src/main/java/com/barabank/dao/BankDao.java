package com.barabank.dao;

import com.barabank.beans.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Ilya Mikheev
 * @author Leonid Zemenkov
 * Интерфейс, определяющий поведение объекта DAO
 */

public interface BankDao {


     List findAllPersons();
     Person findPersonWithPassportID(long passportId);
     Person findPersonByPhone(long phone);
     Person updatePerson(Person person);
     Person savePerson(Person person);

     List<Customer> findAllCustomers();
     Customer findCustomerByPhone(long customer_phone);
     Customer findCustomerById(long id);
     Customer updateCustomer(Customer customer);
     Customer saveCustomer(Customer customer);

     void createUser(Customer customer, Person person);

     Account addAccountForCustomer(Customer customer);
     Account updateAccount(Account account);
     Account findAccountById(long accountId);


     List<BankCard> getAccountBindedCards(long account_number);
     BankCard findCardByCardNumber(long card_number);
   //  BankCard addCardForAccount(BigInteger account_id);
     Account findAccountByCardNumber(long card_number);


     List<Transaction> findAllTransactions();
     List<Transaction> findAllTransactionsForAccount(long account_id);
     List<Transaction> findAllSentAccountTransactions(long account_id);
     List<Transaction> findAllReceivedAccountTransactions(long account_id);
     Transaction saveTransaction(Transaction transaction);


     List<Transaction> getBankTransactionsForPeriod(LocalDate startDate, LocalDate endDate);
     List<Transaction> getBankTransactionsForDay(LocalDate date);
     List<Transaction> getTransactionsForCustomerInPeriod(Customer customer, LocalDate startDate, LocalDate endDate);
     List<Transaction> getTransactionsForCustomerInDate(Customer customer, LocalDate date);
     List<Transaction> getTransactionsForAccountInPeriod(long account, LocalDate startDate, LocalDate endDate);
     List<Transaction> getTransactionsForAccountInDate(long account, LocalDate date);

}
