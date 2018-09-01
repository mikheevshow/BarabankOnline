package com.barabank.service.logic;

//import com.barabank.beans.Transaction;
import com.barabank.service.exceptions.*;

import java.math.BigInteger;

public interface BankTransactionService {

    public void withdrawalFromAccount(BigInteger account, BigInteger sum) throws InsufficientFundsException;

    public void refillAccount(BigInteger account, BigInteger sum);

    public void transferMoney(long fromAccount, long toAccount) throws InsufficientFundsException;

    //public List<Transaction> getTransactionListForAccount(long account);


}
