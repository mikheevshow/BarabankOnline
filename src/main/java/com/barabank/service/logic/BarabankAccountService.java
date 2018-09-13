package com.barabank.service.logic;

import com.barabank.beans.Account;
import com.barabank.beans.Customer;
import com.barabank.dao.BankDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class BarabankAccountService implements BankAccountService {

    private BankDao bankDao;

    public BankDao getBankDao() {
        return bankDao;
    }

    @Autowired
    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    @Override
    public Account openBankAccount(Customer forCustomer, boolean createCard) {
        return null;
    }

    @Override
    public void addCardToAccount(long accountNumber) {

    }

    @Override
    public BigDecimal getBalanceWithAccountId(long accountNumber) {
        return null;
    }

    @Override
    public BigDecimal getBalanceWithCardNumber(long cardNumber) {
        return null;
    }
}
