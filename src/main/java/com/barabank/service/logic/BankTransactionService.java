package com.barabank.service.logic;

//import com.barabank.beans.Transaction;
import com.barabank.service.exceptions.*;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface BankTransactionService {

    public void withdrawalFromAccount(long account, BigDecimal sum) throws InsufficientFundsException;

    public void refillAccount(long account, BigDecimal sum);

    public void transferMoney(long fromAccount, long toAccount, BigDecimal sum) throws InsufficientFundsException;

    //public List<Transaction> getTransactionListForAccount(long account);


}
