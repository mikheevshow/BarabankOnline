package com.barabank.service.logic;

//import com.barabank.beans.Transaction;
import com.barabank.beans.Transaction;
import com.barabank.service.exceptions.*;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface BankTransactionService {

    public void transferMoney(long fromAccount, long toAccount, BigDecimal sum) throws InsufficientFundsException;

    public void addTransaction(Transaction transaction);

    public void withdrawalFromAccount(long account, BigDecimal sum) throws InsufficientFundsException;

    public void refillAccount(long account, BigDecimal sum);

}
