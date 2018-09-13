package com.barabank.service.logic;

import com.barabank.beans.Account;
import com.barabank.beans.Transaction;
import com.barabank.dao.BankDao;
import com.barabank.service.exceptions.InsufficientFundsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

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
        transaction.setDate(OffsetDateTime.now());
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
    @Transactional
    @Override
    public void withdrawalFromAccount(long account, BigDecimal sum) throws InsufficientFundsException {
        Account acc = getBankDao().findAccountByAccountId(account);
        if (acc.getSum().compareTo(sum) >= 0) {
            acc.setSum(acc.getSum().subtract(sum));
            getBankDao().updateAccount(acc);
        } else {
            throw new InsufficientFundsException("Для перевода не хватает" + acc.getSum().subtract(sum));
        }
    }

    /**
     * Пополняет счёт
     * @param account - номер счета пополнения
     * @param sum - сумма пополнения
     */
    @Override
    public void refillAccount(long account, BigDecimal sum) {
        Account acc = getBankDao().findAccountByAccountId(account);
        acc.setSum(acc.getSum().add(sum));
        getBankDao().updateAccount(acc);
    }
}
