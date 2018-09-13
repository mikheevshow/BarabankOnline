package com.barabank.service.logic;

import com.barabank.beans.Account;
import com.barabank.beans.Customer;
import java.math.BigDecimal;

public interface BankAccountService {

    public Account openBankAccount(Customer forCustomer, boolean createCard);

    public void addCardToAccount(long accountNumber);

    public BigDecimal getBalanceWithAccountId(long accountNumber);

    public BigDecimal getBalanceWithCardNumber(long cardNumber);

}
