package com.barabank.service.logic;
import com.barabank.beans.Account;
import com.barabank.beans.Customer;
import com.barabank.beans.Person;
import com.barabank.beans.Transaction;
import com.barabank.dao.BankDao;
import com.barabank.dao.BarabankDao;
import com.barabank.service.exceptions.InsufficientFundsException;
import com.barabank.service.exceptions.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


/**
 * @author Илья Михееа
 * @author Леонид Земенков
 */

@Service
@Transactional
public class BankService implements OnlineBankInterface {


    private BankDao barabankDao;

    private BankDao getBarabankDao() {
        return barabankDao;
    }

    @Autowired
    public void setBarabankDao(BankDao barabankDao) {
        this.barabankDao = barabankDao;
    }


    public Account openBankAccount(Customer customer, boolean createCard) {
        return null;
    }

    public void addCardToAccount(long accountNumber) {
        //Доделать
    }


    public BigDecimal getBalanceWithAccountId(long accountNumber) {
        return getBarabankDao().findAccountByAccountId(accountNumber).getSum() ;
    }


    public BigDecimal getBalanceWithCardNumber(long cardNumber) {
        return getBarabankDao().findAccountByCardNumber(cardNumber).getSum();
    }


    private void withdrawalFromCard(long cardNumber, BigDecimal sum) throws InsufficientFundsException {
        long acc = getBarabankDao().findAccountByCardNumber(cardNumber).getId();
        try {
            withdrawalFromAccount(acc,sum);
        } catch (InsufficientFundsException ex) {
            throw new InsufficientFundsException(ex.getMessage());
        }
    }

    private void refillCard(long cardNumber, BigDecimal sum) {
        refillAccount(getBarabankDao().findAccountByCardNumber(cardNumber).getId(), sum);
    }

    @Transactional
    public void transferMoneyWithCards(long fromCard, long toCard, BigDecimal sum) throws InsufficientFundsException {
        long fromAccount, toAccount;
        try {
            fromAccount = getBarabankDao().findAccountByCardNumber(fromCard).getId();
            toAccount = getBarabankDao().findAccountByCardNumber(toCard).getId();
            transferMoney(fromAccount, toAccount, sum);
        } catch (InsufficientFundsException ex) {
            throw new InsufficientFundsException(ex.getMessage());
        }
    }

    private void withdrawalFromAccount(long account, BigDecimal sum) throws InsufficientFundsException {
        Account acc = getBarabankDao().findAccountByAccountId(account);
        if (acc.getSum().compareTo(sum) >= 0) {
            acc.setSum(acc.getSum().subtract(sum));
            getBarabankDao().updateAccount(acc);
        } else {
            throw new InsufficientFundsException("Для перевода не хватает" + acc.getSum().subtract(sum));
        }
    }

    private void refillAccount(long account, BigDecimal sum) {
        Account acc = getBarabankDao().findAccountByAccountId(account);
        acc.setSum(acc.getSum().add(sum));
        getBarabankDao().updateAccount(acc);
    }

    @Transactional
    public void transferMoney(long fromAccount, long toAccount, BigDecimal sum) throws InsufficientFundsException {
        try {
            withdrawalFromAccount(fromAccount, sum);
            refillAccount(toAccount, sum);
        } catch (InsufficientFundsException ex) {
            throw new InsufficientFundsException(ex.getMessage());
        }

        Transaction transaction = new Transaction();

        transaction.setFromAccount(fromAccount);
        transaction.setToAccount(toAccount);
        transaction.setSum(sum);
        //transaction.setDate(null);

        addTransaction(transaction);
    }

    public Customer findCustomerByPhone(long phone) throws UserNotExistException {
        return null;
    }

    public Person findPersonByPhone(long phone) throws UserNotExistException {
        Person person;
        if ((person = getBarabankDao().findPersonByPhone(phone)) != null) {
            return person;
        } else {
            throw new UserNotExistException("Пользователь не найден");
        }
    }

    public void addPerson(Person person) {
        getBarabankDao().savePerson(person);
    }

    public void addCustomer(Customer customer) {
        getBarabankDao().saveCustomer(customer);
    }

    public void addTransaction(Transaction transaction) {
        getBarabankDao().saveTransaction(transaction);
    }

    @Transactional(readOnly = true)
    public Person findPersonById(long id) {
        return null;
    }

}
