package com.barabank.service.logic;
import com.barabank.beans.Account;
import com.barabank.beans.BankCard;
import com.barabank.beans.Customer;
import com.barabank.dao.BarabankDao;
import com.barabank.service.exceptions.InsufficientFundsException;
import com.barabank.service.exceptions.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * @author Ilya Mikheev
 * @author Leonid Zemenkov
 */

@Service
public class BankService implements OnlineBankInterface {


    private BarabankDao barabankDao;

    private BarabankDao getBarabankDao() {
        return barabankDao;
    }

    @Autowired
    public void setBarabankDao(BarabankDao barabankDao) {
        this.barabankDao = barabankDao;
    }

    public Account openBankAccount(boolean createCard) {

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

    public void withdrawalFromCard(long cardNumber, BigDecimal sum) throws InsufficientFundsException {
        long acc = getBarabankDao().findAccountByCardNumber(cardNumber).getId();
        try {
            withdrawalFromAccount(acc,sum);
        } catch (InsufficientFundsException ex) {
            throw new InsufficientFundsException(ex.getMessage());
        }
    }

    public void refillCard(long cardNumber, BigDecimal sum) {
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

    public void withdrawalFromAccount(long account, BigDecimal sum) throws InsufficientFundsException {
        Account acc = getBarabankDao().findAccountByAccountId(account);
        if (acc.getSum().compareTo(sum) >= 0) {
            acc.setSum(acc.getSum().subtract(sum));
            getBarabankDao().updateAccount(acc);
        } else {
            throw new InsufficientFundsException("Для перевода не хватает" + acc.getSum().subtract(sum));
        }
    }

    public void refillAccount(long account, BigDecimal sum) {
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
    }

    public Customer findCustomerByPhone(long phone) throws UserNotExistException {
        return null;
    }


}
