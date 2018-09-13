package com.barabank.service.logic;

import com.barabank.dao.BankDao;
import com.barabank.service.exceptions.InsufficientFundsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author Ilya Mikheev
 * @author Leonid Zemenkov
 */

public class BarabankCardOperationService implements BankCardOperationService {

    private BankTransactionService bankTransactionService;

    private BankDao bankDao;

    private BankDao getBankDao() {
        return bankDao;
    }

    @Autowired
    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    private BankTransactionService getBankTransactionService() {
        return bankTransactionService;
    }

    @Autowired
    public void setBankTransactionService(BankTransactionService bankTransactionService) {
        this.bankTransactionService = bankTransactionService;
    }

    /**
     *
     * @param fromCard - номер карты отправителя средств
     * @param toCard - номер карты получателя средств
     * @param sum - переводимая сумма
     * @throws InsufficientFundsException - исключение, создаваемое при нехватке средств на счете
     */
    @Transactional
    @Override
    public void transferMoneyWithCards(long fromCard, long toCard, BigDecimal sum) throws InsufficientFundsException {
        long fromAccount, toAccount;
        try {
            fromAccount = getBankDao().findAccountByCardNumber(fromCard).getId();
            toAccount = getBankDao().findAccountByCardNumber(toCard).getId();
            getBankTransactionService().transferMoney(fromAccount, toAccount, sum);
        } catch (InsufficientFundsException ex) {
            throw new InsufficientFundsException(ex.getMessage());
        }
    }
}
