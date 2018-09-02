package com.barabank.dao;

import com.barabank.beans.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional(readOnly = true)
@Repository("barabankDao")
public class BarabankDao implements Dao {

    private final SessionFactory sessionFactory;

    @Autowired
    public BarabankDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public List<Person> findAllPersons() {
        return null;
    }


    public Person findPersonPassportID(long ID) {
        return null;
    }


    public Person findPersonByPhone(long person_phone) {
        return null;
    }

    @Transactional(readOnly = false)
    public Person updatePerson(Person person) {
        return null;
    }

    @Transactional(readOnly = false)
    public Person savePerson(Person person) {
        return null;
    }

    public List<Customer> findAllCustomers() {
        return null;
    }

    public Customer findCustomerByPhone(long customer_phone) {
        return null;
    }

    public Customer findById(long id) {
        return null;
    }

    @Transactional(readOnly = false)
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Transactional(readOnly = false)
    public Customer saveCustomer(Customer customer) {
        return null;
    }

    public List<Account> findAllAccountsForCustomer(Customer user) {
        return null;
    }

    public List<Account> findAllAccountWithCustomerPhone(long phone) {
        return null;
    }

    public Account findAccountByAccountId(long account_id) {
        return null;
    }

    @Transactional(readOnly = false)
    public void addAccountForCustomer(Customer customer) {

    }

    @Transactional(readOnly = false)
    public Account updateAccount(Account account) {
        return null;
    }

    @Transactional(readOnly = false)
    public Account saveAccount(Account account) {
        return null;
    }

    public List<BankCard> getAccountBindedCards(long account_number) {
        return null;
    }

    @Transactional(readOnly = false)
    public BankCard addCardForAccount(long account_id) {
        return null;
    }

    public Account findAccountByCardNumber(long card_number) {
        return null;
    }

    public List<Transaction> findAllTransactionsForAccount(long account_id) {
        return null;
    }

    public List<Transaction> findAllSendedAccountTransactions(long account_id) {
        return null;
    }

    public List<Transaction> findAllReceivedAccountTransactions(long account_id) {
        return null;
    }

    @Transactional(readOnly = false)
    public Transaction saveTransaction(Transaction transaction) {
        return null;
    }
}
