package com.barabank.service.logic;

import com.barabank.beans.Account;
import com.barabank.beans.Customer;
import com.barabank.service.enums.BankCardPaymentSystem;

import java.math.BigDecimal;

public interface BankAccountService {

     Account openBankAccountFor(Customer forCustomer);

     void addCardToAccount(long accountNumber, BankCardPaymentSystem bankCardPaymentSystem);

     BigDecimal getBalanceWithAccountId(long accountNumber);

     BigDecimal getBalanceWithCardNumber(long cardNumber);

     Account findAccountById(long accountId);

}
