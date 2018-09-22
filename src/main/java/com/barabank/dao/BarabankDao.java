package com.barabank.dao;

import com.barabank.beans.*;
import com.barabank.service.exceptions.UserNotExistException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ilya Mikheev
 * @author Leonid Zemenkov
 */

@Transactional
@Repository("barabankDao")
public class BarabankDao implements BankDao {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Person> findAllPersons() {
        return entityManager.createQuery("from Person").getResultList();
    }

    @Override
    public Person findPersonWithPassportID(long passportId)  throws NoResultException{
            return (Person) entityManager.createQuery("from Person p where p.passportId=:passportId").
                    setParameter("passportId", passportId).getSingleResult();
    }


    @Override
    public Person findPersonByPhone(long phone) throws NoResultException{
            return findCustomerByPhone(phone).getPerson();
    }

    @Override
    public Person updatePerson(Person person) {
        entityManager.merge(person);
        return person;
    }

    @Override
    public Person savePerson(Person person) {
        entityManager.persist(person);
        return person;
    }

    @Override
    public List<Customer> findAllCustomers() {
        return entityManager.createQuery("from Customer c",Customer.class).getResultList();
    }

    @Override
    public Customer findCustomerByPhone(long phone) throws NoResultException {
            return (Customer) entityManager.createQuery("from Customer c where c.phone=:phone").
                    setParameter("phone", phone).getSingleResult();
    }

    @Override
    public Customer findCustomerById(long customerId) throws NoResultException{
            return (Customer) entityManager.createQuery("from Customer c where c.customerId=:customerId").
                    setParameter("customerId", customerId).getSingleResult();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        entityManager.merge(customer);
        return customer;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }

    @Override
    public void createUser(Customer customer, Person person) {
        entityManager.persist(customer);
        entityManager.persist(person);
    }

    @Override
    public Account addAccountForCustomer(Customer customer) {
        Account account = new Account();
        customer.addAccount(account);
        account.setCustomer(customer);
        entityManager.persist(account);
        return account;
    }

    @Override
    public Account updateAccount(Account account) {
        entityManager.merge(account);
        return account;
    }

    @Override
    public Account findAccountById(long accountId) throws NoResultException{
        return (Account)entityManager.createQuery("from Account a where a.accountId=:id").
                setParameter("id",accountId).getSingleResult();
    }

    @Override
    public List<BankCard> getAccountBindedCards(long account_number) {
        return null;
    }

    @Override
    public BankCard findCardByCardNumber(long card_number) {
        return null;
    }

    @Override
    public Account findAccountByCardNumber(long card_number) {
        return null;
    }



    @Override
    public List<Transaction> findAllTransactions() {
        return entityManager.createQuery("from Transaction ").getResultList();
    }

    @Override
    public List<Transaction> findAllTransactionsForAccount(long accountId) throws NoResultException{
        return entityManager.createQuery("from Transaction t where t.fromAccount=:id OR t.toAccount=:id").
                setParameter("id",accountId).getResultList();
    }

    @Override
    public List<Transaction> findAllSentAccountTransactions(long accountId) throws NoResultException{
        return entityManager.createQuery("from Transaction  t where t.fromAccount=:id").
                setParameter("id",accountId).getResultList();
    }

    @Override
    public List<Transaction> findAllReceivedAccountTransactions(long accountId) throws NoResultException{
        return entityManager.createQuery("from Transaction  t where t.toAccount=:id").
                setParameter("id",accountId).getResultList();
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        entityManager.persist(transaction);
        return transaction;
    }

    @Override
    public List<Transaction> getBankTransactionsForPeriod(LocalDate startDate, LocalDate endDate) {
        LocalDateTime start = LocalDateTime.of(startDate, LocalTime.MIN);
        LocalDateTime end = LocalDateTime.of(endDate,LocalTime.MAX);
        return entityManager.createQuery("from Transaction t where t.date>= :startDate AND t.date <= :endDate").
                setParameter("startDate",startDate).setParameter("endDate",endDate).getResultList();
    }

    @Override
    public List<Transaction> getBankTransactionsForDay(LocalDate date) {
        LocalDateTime startDate = LocalDateTime.of(date, LocalTime.MIN);
        LocalDateTime endDate = LocalDateTime.of(date,LocalTime.MAX);
        return entityManager.createQuery("from Transaction t where t.date >=:startDate and t.date<=:endDate").
                setParameter("startDate",startDate).setParameter("endDate",endDate).getResultList();
    }

    @Override
    public List<Transaction> getTransactionsForCustomerInPeriod(Customer customer, LocalDate startDate, LocalDate endDate) {
        List<Transaction> transactions= new LinkedList<>();
        for(Account account: customer.getAccounts()){
            transactions.addAll(getTransactionsForAccountInPeriod(account.getAccountId(),startDate,endDate));
        }
        return transactions;
    }

    @Override
    public List<Transaction> getTransactionsForCustomerInDate(Customer customer, LocalDate date) {
        List<Transaction> transactions= new LinkedList<>();
        for(Account account: customer.getAccounts()){
            transactions.addAll(getTransactionsForAccountInDate(account.getAccountId(),date));
        }
        return transactions;
    }

    @Override
    public List<Transaction> getTransactionsForAccountInPeriod(long account, LocalDate startDate, LocalDate endDate) {
        LocalDateTime start = LocalDateTime.of(startDate,LocalTime.MIN);
        LocalDateTime end = LocalDateTime.of(endDate,LocalTime.MAX);
        return entityManager.createQuery("from Transaction t where (t.fromAccount=:account or t.toAccount=:account) and t.date>=:startDate and t.date<=:endDate").
                setParameter("account",account).setParameter("startDate",start).setParameter("endDate",end).getResultList();
    }

    @Override
    public List<Transaction> getTransactionsForAccountInDate(long account, LocalDate date) {
        LocalDateTime startDate = LocalDateTime.of(date, LocalTime.MIN);
        LocalDateTime endDate = LocalDateTime.of(date,LocalTime.MAX);
        return entityManager.createQuery("from Transaction t where (t.fromAccount=:account or t.toAccount=:account) and t.date>=:startDate and t.date<= :endDate").
                setParameter("account",account).setParameter("startDate",date).setParameter("endDate",endDate).getResultList();
    }
}
