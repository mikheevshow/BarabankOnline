package com.barabank.service.logic;
import com.barabank.beans.Account;
import com.barabank.beans.Customer;
import com.barabank.service.exceptions.InsufficientFundsException;
import com.barabank.service.exceptions.UserNotExistException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * @author Ilya Mikheev
 * @author Leonid Zemenkov
 */
public class BankService implements OnlineBankInterface {

    public Account openBankAccount(boolean createCard) {
        return null;
    }

    public void addCardToAccount(BigInteger accountNumber) {

    }

    public BigDecimal getBalanceWithAccountId(long accountNumber) {
        return null;
    }

    public BigDecimal getBalandeWithCardNumber(long cardNumber) {
        return null;
    }

    public void withdrawalFromCard(BigInteger account, BigInteger sum) throws InsufficientFundsException {

    }

    public void refillCard(BigInteger card, BigInteger sum) {

    }

    public void transferMoneyWithCards(long fromCard, long toCard) throws InsufficientFundsException {

    }

    public void withdrawalFromAccount(BigInteger account, BigInteger sum) throws InsufficientFundsException {

    }

    public void refillAccount(BigInteger account, BigInteger sum) {

    }

    public void transferMoney(long fromAccount, long toAccount) throws InsufficientFundsException {

    }

    public Customer findCustomerByPhone(long phone) throws UserNotExistException {
        return null;
    }
}
