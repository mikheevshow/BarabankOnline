package com.barabank.service.logic;

import com.barabank.service.exceptions.InsufficientFundsException;

import java.math.BigInteger;

public interface BankCardOperationService {

    public void withdrawalFromCard(BigInteger account, BigInteger sum) throws InsufficientFundsException;

    public void refillCard(BigInteger card, BigInteger sum);

    public void transferMoneyWithCards(long fromCard, long toCard) throws InsufficientFundsException;

}
