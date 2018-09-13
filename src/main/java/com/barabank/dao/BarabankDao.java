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
 * @author Leonid Zemenkov
 */

@Transactional(readOnly = true)
@Repository("barabankDao")
public class BarabankDao implements BankDao {

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


    public Person findPersonWithPassportID(long ID) {
        return (Person) getSessionFactory().getCurrentSession().createQuery("FROM Person p WHERE p.id = :ID").setParameter("ID", ID).uniqueResult();
    }


    public Person findPersonByPhone(long person_phone) {
        return (Person) getSessionFactory().getCurrentSession().createQuery("FROM Person p WHERE p.phone = :phone").setParameter("phone", person_phone).uniqueResult();
    }

    @Transactional(readOnly = false)
    public Person updatePerson(Person person) {
        getSessionFactory().getCurrentSession().update(person);
        return person;
    }

    @Transactional(readOnly = false)
    public void savePerson(Person person) {
        getSessionFactory().getCurrentSession().save(person);
    }


















    public List<Customer> findAllCustomers() {
        return getSessionFactory().getCurrentSession().createQuery("FROM Customer c").list();
    }

    public Customer findCustomerByPhone(long customer_phone) {
        return (Customer) getSessionFactory().getCurrentSession().createQuery("FROM Customer c WHERE c.phone = :customer_phone").setParameter("customer_phone", customer_phone).uniqueResult();
    }

    public Customer findById(long id) {
        return (Customer) getSessionFactory().getCurrentSession().createQuery("FROM Customer c WHERE c.id = :id").setParameter("id", id).uniqueResult();
    }

    @Transactional(readOnly = false)
    public Customer updateCustomer(Customer customer) {
        getSessionFactory().getCurrentSession().update(customer);
        return customer;
    }

    @Transactional(readOnly = false)
    public void saveCustomer(Customer customer) {
        getSessionFactory().getCurrentSession().save(customer);
    }






















    public List<Account> findAllAccountsForCustomer(Customer customer) {
        //BigInteger customer_id = user.getId();
        return getSessionFactory().getCurrentSession().createQuery("FROM Account a WHERE  a.customer = :customer").setParameter("customer", customer).list();
    }

    public List<Account> findAllAccountWithCustomerPhone(long phone) {
        Customer customer = findCustomerByPhone(phone);
        return getSessionFactory().getCurrentSession().createQuery("FROM Account a WHERE a.customer = :customer").setParameter("customer", customer).list();
    }

    public Account findAccountByAccountId(long account_id) {
        return (Account) getSessionFactory().getCurrentSession().createQuery("FROM Account a WHERE a.id = :account_id").setParameter("account_id", account_id).uniqueResult();
    }

    @Transactional(readOnly = false)
    public void addAccountForCustomer(Customer customer) {

        //getSessionFactory().getCurrentSession().createQuery("INSERT INTO Account(id, customer, sum) SELECT customer FROM Customer c");
    }

    @Transactional(readOnly = false)
    public void updateAccount(Account account) {
        getSessionFactory().getCurrentSession().update(account);
    }

    @Transactional(readOnly = false)
    public Account saveAccount(Account account) {
        getSessionFactory().getCurrentSession().save(account);
        return account;
    }

    public List<BankCard> getAccountBindedCards(long account_number) {

        return getSessionFactory().getCurrentSession().createQuery("FROM BankCard bc WHERE bc.account = :account_number").setParameter("account_number", account_number).list();
    }

//    @Transactional(readOnly = false)
//    public BankCard addCardForAccount(BigInteger account_id) {
//        getSessionFactory().getCurrentSession().createQuery("INSERT INTO BankCard() ")
//        return null;
//    }

    public BankCard findCardByCardNumber(long card_number) {
        return (BankCard) getSessionFactory().getCurrentSession().createQuery("FROM BankCard bc WHERE bc.cardNumber = :card_number").setParameter("card_number", card_number).uniqueResult();
    }

    public Account findAccountByCardNumber(long card_number) {
        long account_number = findCardByCardNumber(card_number).getCardNumber();
        return findAccountByAccountId(account_number);
    }




















    /**
     * Метод, позволяющий получить список транзакций в которых участвует передаваемый банковский счет
     * @param account_id - номер банковского счета
     * @return список транзакций
     */
    @Transactional(readOnly = true)
    public List<Transaction> findAllTransactionsForAccount(long account_id) {
        return getSessionFactory().getCurrentSession().createQuery("FROM Transaction t WHERE t.fromAccount = :account_id OR t.toAccount = :account_id ").setParameter("account_id", account_id).list();
    }

    /**
     * Метод, позволяющий получить список транзакций, в которых передаваемый банковский счет выступает в качестве отправителя средств
     * @param account_id - номер банковского счета
     * @return список транзакций
     */
    @Transactional(readOnly = true)
    public List<Transaction> findAllSentAccountTransactions(long account_id) {
        return getSessionFactory().getCurrentSession().createQuery("FROM Transaction t WHERE t.fromAccount = :account_id").setParameter("account_id", account_id).list();
    }

    /**
     * Метод, позволяющий получить список транзакций, в которых передаваемый банковский счет выступает в получателя средств
     * @param account_id - номер банковского счета
     * @return список транзакций
     */
    @Transactional(readOnly = true)
    public List<Transaction> findAllReceivedAccountTransactions(long account_id) {

        return getSessionFactory().getCurrentSession().createQuery("FROM Transaction t WHERE t.toAccount = :account_id").setParameter("account_id", account_id).list();
    }

    /**
     * Метод, сохраняющий транзакцию в базу данных
     * @param transaction - транзакция
     */
    @Transactional(readOnly = false)
    public void saveTransaction(Transaction transaction) {
        getSessionFactory().getCurrentSession().save(transaction);
    }


}
