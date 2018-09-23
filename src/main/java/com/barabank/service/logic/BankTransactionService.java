package com.barabank.service.logic;

import com.barabank.beans.Account;
import com.barabank.beans.Customer;
import com.barabank.beans.Transaction;
import com.barabank.service.exceptions.*;

import javax.persistence.NoResultException;
import java.math.BigDecimal;

public interface BankTransactionService {

     void transferMoney(long fromAccount, long toAccount, BigDecimal sum)
             throws InsufficientFundsException,NoResultException;

     void addTransaction(Transaction transaction);

     void withdrawalFromAccount(long accountId, BigDecimal sum) throws InsufficientFundsException, NoResultException;

     void refillAccount(long accountId, BigDecimal sum) throws NoResultException;

     void checkCustomerAccount (Customer customer,long accountId) throws AccountNumberExeption;

}
