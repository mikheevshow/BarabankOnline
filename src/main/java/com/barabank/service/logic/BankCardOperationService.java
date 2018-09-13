package com.barabank.service.logic;

import com.barabank.service.exceptions.InsufficientFundsException;
import java.math.BigDecimal;

public interface BankCardOperationService {

    public void transferMoneyWithCards(long fromCard, long toCard, BigDecimal sum) throws InsufficientFundsException;

}
