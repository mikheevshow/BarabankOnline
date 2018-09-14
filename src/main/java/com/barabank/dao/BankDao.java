package com.barabank.dao;

import com.barabank.beans.*;
import com.barabank.service.logic.TransactionReportType;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Ilya Mikheev
 * Интерфейс, определяющий поведение объекта DAO
 */

public interface BankDao {


    public List<Person> findAllPersons();
    public Person findPersonWithPassportID(long ID);
    public Person findPersonByPhone(long person_phone);
    public Person updatePerson(Person person);
    public void savePerson(Person person);

    public List<Customer> findAllCustomers();
    public Customer findCustomerByPhone(long customer_phone);
    public Customer findById(long id);
    public Customer updateCustomer(Customer customer);
    public void saveCustomer(Customer customer);

    public List<Account> findAllAccountsForCustomer(Customer user);
    public List<Account> findAllAccountWithCustomerPhone(long phone);
    public Account findAccountByAccountId(long account_id);
    public void addAccountForCustomer(Customer customer);
    public void updateAccount(Account account);
    public Account saveAccount(Account account);

    public List<BankCard> getAccountBindedCards(long account_number);
    public BankCard findCardByCardNumber(long card_number);
   // public BankCard addCardForAccount(BigInteger account_id);
    public Account findAccountByCardNumber(long card_number);


    public List<Transaction> findAllTransactions();
    public List<Transaction> findAllTransactionsForAccount(long account_id);
    public List<Transaction> findAllSentAccountTransactions(long account_id);
    public List<Transaction> findAllReceivedAccountTransactions(long account_id);
    public void saveTransaction(Transaction transaction);


    public List<Transaction> getBankTransactionsForPeriod(LocalDate startDate, LocalDate endDate);
    public List<Transaction> getBankTransactionsForDay(LocalDate date);
    public List<Transaction> getTransactionsForCustomerInPeriod(Customer customer, LocalDate startDate, LocalDate endDate);
    public List<Transaction> getTransactionsForCustomerInDate(Customer customer, LocalDate date);
    public List<Transaction> getTransactionsForAccountInPeriod(long account, LocalDate startDate, LocalDate endDate);
    public List<Transaction> getTransactionsForAccountInDate(long account, LocalDate date);

}
