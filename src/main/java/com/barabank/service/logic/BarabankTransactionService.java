package com.barabank.service.logic;

import com.barabank.beans.Account;
import com.barabank.beans.Customer;
import com.barabank.beans.Transaction;
import com.barabank.dao.BankDao;
import com.barabank.service.exceptions.AccountNumberExeption;
import com.barabank.service.exceptions.InsufficientFundsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Ilya Mikheev
 * @author Leonid Zemenkov
 */


@Service
@Transactional
public class BarabankTransactionService implements BankTransactionService {

    private BankDao bankDao;

    @Autowired
    public BarabankTransactionService(BankDao bankDao) {
        this.bankDao = bankDao;
    }



    /**
     * Переводит деньги с одного счета на другой
     * @param fromAccount - номер счета отправителя
     * @param toAccount - номер счета получателя
     * @param sum - переводимая сумма
     * @throws InsufficientFundsException - исключение, возникающее при недостатке средств на счете отправителя
     */
    @Override
    public void transferMoney(long fromAccount, long toAccount, BigDecimal sum) throws InsufficientFundsException, NoResultException{
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
            transaction.setDate(LocalDateTime.now());
            addTransaction(transaction);
    }


    /**
     * Добавляет транзакцию в список транзакций
     * @param transaction - транзакция
     */
    @Override
    public void addTransaction(Transaction transaction) {
        bankDao.saveTransaction(transaction);
    }

    /**
     * Списывает средсва со счёта
     * @param accountId - номер счета списания
     * @param sum - сумма списания
     * @throws InsufficientFundsException - исключение, возникающее при недостатке средств на счете списания
     */
    @Override
    public void withdrawalFromAccount(long accountId, BigDecimal sum) throws InsufficientFundsException,NoResultException {
        Account account = bankDao.findAccountById(accountId);
        if (account.getBalance().compareTo(sum) >= 0) {
            account.setBalance(account.getBalance().subtract(sum));
            bankDao.updateAccount(account);
        } else {
            throw new InsufficientFundsException("Для перевода не хватает" + account.getBalance().subtract(sum));
        }
    }

    /**
     * Пополняет счёт
     * @param accountId - номер счета пополнения
     * @param sum - сумма пополнения
     */
    @Override
    public void refillAccount(long accountId, BigDecimal sum) throws NoResultException{
        Account account = bankDao.findAccountById(accountId);
        account.setBalance(account.getBalance().add(sum));
        bankDao.updateAccount(account);
    }

    @Override
    public void checkCustomerAccount(Customer customer,long accountId) throws AccountNumberExeption,NoResultException {
       if(customer.getCustomerId() != bankDao.findAccountById(accountId).getCustomerId()){
           throw new AccountNumberExeption("Неверный номер счета: "+accountId);
       }
    }
}
