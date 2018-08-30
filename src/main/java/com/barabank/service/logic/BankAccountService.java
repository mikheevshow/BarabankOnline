package com.barabank.service.logic;

import com.barabank.beans.Account;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface BankAccountService {

    public Account openBankAccount(boolean createCard);

    public void addCardToAccount(BigInteger accountNumber);

    public BigDecimal getBalanceWithAccountId(long accountNumber);

    public BigDecimal getBalandeWithCardNumber(long cardNumber);
}
