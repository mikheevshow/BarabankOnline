package com.barabank.service.logic;

import com.barabank.beans.Account;
import com.barabank.beans.Customer;
import com.barabank.service.enums.BankCardPaymentSystem;

import java.math.BigDecimal;

public interface BankAccountService {

    public Account openBankAccountFor(Customer forCustomer);

    public void addCardToAccount(long accountNumber, BankCardPaymentSystem bankCardPaymentSystem);

    public BigDecimal getBalanceWithAccountId(long accountNumber);

    public BigDecimal getBalanceWithCardNumber(long cardNumber);

}
