package com.barabank.dao;

import com.barabank.beans.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Ilya Mikheev
 * Интерфейс, определяющий поведение объекта DAO
 */

public interface BankDao {


    public List findAllPersons();
    public Person findPersonWithPassportID(long passportId);
    public Person findPersonByPhone(long phone);
    public Person updatePerson(Person person);
    public Person savePerson(Person person);

    public List<Customer> findAllCustomers();
    public Customer findCustomerByPhone(long customer_phone);
    public Customer findById(long id);
    public Customer updateCustomer(Customer customer);
    public Customer saveCustomer(Customer customer);

    public void createUser(Customer customer, Person person);

    public Account addAccountForCustomer(Customer customer);
    public Account updateAccount(Account account);
    public Account findAccountById(long accountId);


    public List<BankCard> getAccountBindedCards(long account_number);
    public BankCard findCardByCardNumber(long card_number);
   // public BankCard addCardForAccount(BigInteger account_id);
    public Account findAccountByCardNumber(long card_number);


    public List<Transaction> findAllTransactions();
    public List<Transaction> findAllTransactionsForAccount(long account_id);
    public List<Transaction> findAllSentAccountTransactions(long account_id);
    public List<Transaction> findAllReceivedAccountTransactions(long account_id);
    public Transaction saveTransaction(Transaction transaction);


    public List<Transaction> getBankTransactionsForPeriod(LocalDate startDate, LocalDate endDate);
    public List<Transaction> getBankTransactionsForDay(LocalDate date);
    public List<Transaction> getTransactionsForCustomerInPeriod(Customer customer, LocalDate startDate, LocalDate endDate);
    public List<Transaction> getTransactionsForCustomerInDate(Customer customer, LocalDate date);
    public List<Transaction> getTransactionsForAccountInPeriod(long account, LocalDate startDate, LocalDate endDate);
    public List<Transaction> getTransactionsForAccountInDate(long account, LocalDate date);

}
