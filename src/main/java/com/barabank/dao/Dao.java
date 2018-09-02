package com.barabank.dao;

import com.barabank.beans.*;
import java.util.List;

/**
 * @author Ilya Mikheev
 */


public interface Dao {

    public List<Person> findAllPersons();
    public Person findPersonPassportID(long ID);
    public Person findPersonByPhone(long person_phone);
    public Person updatePerson(Person person);
    public Person savePerson(Person person);

    public List<Customer> findAllCustomers();
    public Customer findCustomerByPhone(long customer_phone);
    public Customer findById(long id);
    public Customer updateCustomer(Customer customer);
    public Customer saveCustomer(Customer customer);

    public List<Account> findAllAccountsForCustomer(Customer user);
    public List<Account> findAllAccountWithCustomerPhone(long phone);
    public Account findAccountByAccountId(long account_id);
    public void addAccountForCustomer(Customer customer);
    public Account updateAccount(Account account);
    public Account saveAccount(Account account);

    public List<BankCard> getAccountBindedCards(long account_number);
    public BankCard addCardForAccount(long account_id);
    public Account findAccountByCardNumber(long card_number);

    public List<Transaction> findAllTransactionsForAccount(long account_id);
    public List<Transaction> findAllSendedAccountTransactions(long account_id);
    public List<Transaction> findAllReceivedAccountTransactions(long account_id);
    public Transaction saveTransaction(Transaction transaction);

}
