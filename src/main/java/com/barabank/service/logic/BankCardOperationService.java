package com.barabank.service.logic;

import com.barabank.service.exceptions.InsufficientFundsException;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface BankCardOperationService {

    public void withdrawalFromCard(long account, BigDecimal sum) throws InsufficientFundsException;

    public void refillCard(long card, BigDecimal sum);

    public void transferMoneyWithCards(long fromCard, long toCard, BigDecimal sum) throws InsufficientFundsException;

}
