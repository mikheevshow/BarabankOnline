package com.barabank.service.logic;

import com.barabank.beans.Account;
import com.barabank.beans.Transaction;
import com.barabank.dao.BankDao;
import com.barabank.service.exceptions.InsufficientFundsException;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    @Override
    public void addTransaction(Transaction transaction) {
        getBankDao().saveTransaction(transaction);
    }

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

    @Override
    public void refillAccount(long account, BigDecimal sum) {
        Account acc = getBankDao().findAccountByAccountId(account);
        acc.setSum(acc.getSum().add(sum));
        getBankDao().updateAccount(acc);
    }
}
