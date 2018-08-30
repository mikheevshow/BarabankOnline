package com.barabank.service.logic;

import com.barabank.beans.Transaction;
import com.barabank.service.exceptions.*;

import com.barabank.beans.Account;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public interface BankTransactionService {


    public void withdrawalFromAccount(BigInteger account, BigInteger sum) throws insufficientFundsException;

    public void refillAccount(BigInteger account, BigInteger sum);

    public void transferMoney(long fromAccount, long toAccount) throws insufficientFundsException;

    public List<Transaction> getTransactionListForAccount(long account);


}
