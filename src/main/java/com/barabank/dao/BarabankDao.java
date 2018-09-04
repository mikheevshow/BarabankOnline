package com.barabank.dao;

import com.barabank.beans.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Ilya Mikheev
 *
 */

@Transactional(readOnly = true)
@Repository("barabankDao")
public class BarabankDao implements Dao {

    private final SessionFactory sessionFactory;

    @Autowired
    public BarabankDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public List<Person> findAllPersons() {
        return getSessionFactory().getCurrentSession().createQuery("FROM Person p").list();
    }


    public Person findPersonPassportID(long ID) {
        return (Person) getSessionFactory().getCurrentSession().createQuery("FROM Person p WHERE p.id = :ID").uniqueResult();
    }


    public Person findPersonByPhone(long person_phone) {
        return (Person) getSessionFactory().getCurrentSession().createQuery("FROM Person p WHERE p.phone = :phone").uniqueResult();
    }

    @Transactional(readOnly = false)
    public Person updatePerson(Person person) {
        getSessionFactory().getCurrentSession().update(person);
        return person;
    }

    @Transactional(readOnly = false)
    public Person savePerson(Person person) {
        getSessionFactory().getCurrentSession().save(person);
        return person;
    }

    public List<Customer> findAllCustomers() {
        return getSessionFactory().getCurrentSession().createQuery("FROM Customer c").list();
    }

    public Customer findCustomerByPhone(long customer_phone) {
        return (Customer) getSessionFactory().getCurrentSession().createQuery("FROM Customer c WHERE c.phone = :customer_phone").uniqueResult();
    }

    public Customer findById(long id) {
        return (Customer) getSessionFactory().getCurrentSession().createQuery("FROM Customer c WHERE c.id = :id").uniqueResult();
    }

    @Transactional(readOnly = false)
    public Customer updateCustomer(Customer customer) {
        getSessionFactory().getCurrentSession().update(customer);
        return customer;
    }

    @Transactional(readOnly = false)
    public Customer saveCustomer(Customer customer) {
        getSessionFactory().getCurrentSession().save(customer);
        return customer;
    }

    public List<Account> findAllAccountsForCustomer(Customer user) {
        //BigInteger customer_id = user.getId();
        return getSessionFactory().getCurrentSession().createQuery("FROM Account a WHERE  a.customer = :user").list();
    }

    public List<Account> findAllAccountWithCustomerPhone(long phone) {
        Customer customer = findCustomerByPhone(phone);
        return getSessionFactory().getCurrentSession().createQuery("FROM Account a WHERE a.customer = :customer").list();
    }

    public Account findAccountByAccountId(long account_id) {
        return (Account) getSessionFactory().getCurrentSession().createQuery("FROM Account a WHERE a.id = :account_id").uniqueResult();
    }

    @Transactional(readOnly = false)
    public void addAccountForCustomer(Customer customer) {

        Customer c = customer;
        getSessionFactory().getCurrentSession().createQuery("INSERT INTO Account(id, customer, sum) SELECT customer FROM Customer c");
    }

    @Transactional(readOnly = false)
    public Account updateAccount(Account account) {
        getSessionFactory().getCurrentSession().update(account);
        return account;
    }

    @Transactional(readOnly = false)
    public Account saveAccount(Account account) {
        getSessionFactory().getCurrentSession().save(account);
        return account;
    }

    public List<BankCard> getAccountBindedCards(long account_number) {

        return getSessionFactory().getCurrentSession().createQuery("FROM BankCard bc WHERE bc.account = :account_number").list();
    }

//    @Transactional(readOnly = false)
//    public BankCard addCardForAccount(BigInteger account_id) {
//        getSessionFactory().getCurrentSession().createQuery("INSERT INTO BankCard() ")
//        return null;
//    }

    public BankCard findCardByCardNumber(long card_number) {
        return (BankCard) getSessionFactory().getCurrentSession().createQuery("FROM BankCard bc WHERE bc.cardNumber = :card_number").uniqueResult();
    }

    public Account findAccountByCardNumber(long card_number) {
        long account_number = findCardByCardNumber(card_number).getCardNumber();
        return findAccountByAccountId(account_number);
    }

    public List<Transaction> findAllTransactionsForAccount(long account_id) {
        return getSessionFactory().getCurrentSession().createQuery("FROM Transaction t WHERE t.fromAccount = :account_id OR t.toAccount = :account_id ").list();
    }

    public List<Transaction> findAllSentAccountTransactions(long account_id) {
        return getSessionFactory().getCurrentSession().createQuery("FROM Transaction t WHERE t.fromAccount = :account_id").list();
    }

    public List<Transaction> findAllReceivedAccountTransactions(long account_id) {

        return getSessionFactory().getCurrentSession().createQuery("FROM Transaction t WHERE t.toAccount = :account_id").list();
    }

    @Transactional(readOnly = false)
    public Transaction saveTransaction(Transaction transaction) {
        getSessionFactory().getCurrentSession().save(transaction);
        return transaction;
    }


}
