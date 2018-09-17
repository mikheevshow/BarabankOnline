package com.barabank.service.logic;

import com.barabank.beans.Account;
import com.barabank.beans.Transaction;
import com.barabank.dao.BankDao;
import com.barabank.service.exceptions.InsufficientFundsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    private BankDao getBankDao() {
        return bankDao;
    }

    @Autowired
    public void setBankDao(BankDao bankDao) {
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
        transaction.setDate(LocalDateTime.now());
        addTransaction(transaction);
    }

    /**
     * Добавляет транзакцию в список транзакций
     * @param transaction - транзакция
     */
    @Override
    public void addTransaction(Transaction transaction) {
        getBankDao().saveTransaction(transaction);
    }

    /**
     * Списывает средсва со счёта
     * @param account - номер счета списания
     * @param sum - сумма списания
     * @throws InsufficientFundsException - исключение, возникающее при недостатке средств на счете списания
     */
    @Override
    public void withdrawalFromAccount(long account, BigDecimal sum) throws InsufficientFundsException {
        Account acc = getBankDao().findAccountById(account);
        if (acc.getBalance().compareTo(sum) >= 0) {
            acc.setBalance(acc.getBalance().subtract(sum));
            getBankDao().updateAccount(acc);
        } else {
            throw new InsufficientFundsException("Для перевода не хватает" + acc.getBalance().subtract(sum));
        }
    }

    /**
     * Пополняет счёт
     * @param account - номер счета пополнения
     * @param sum - сумма пополнения
     */
    @Override
    public void refillAccount(long account, BigDecimal sum) {
        Account acc = getBankDao().findAccountById(account);
        acc.setBalance(acc.getBalance().add(sum));
        getBankDao().updateAccount(acc);
    }
}
