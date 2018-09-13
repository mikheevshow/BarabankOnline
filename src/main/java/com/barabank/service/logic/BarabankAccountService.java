package com.barabank.service.logic;

import com.barabank.beans.Account;
import com.barabank.beans.Customer;
import com.barabank.dao.BankDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @author Ilya Mikheev
 * @author Leonid Zemenkov
 */

public class BarabankAccountService implements BankAccountService {

    private BankDao bankDao;

    public BankDao getBankDao() {
        return bankDao;
    }

    @Autowired
    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    /**
     * Открывает новый счет для клиента банка
     * @param forCustomer - клиент банка
     * @param createCard - создать или не создать карту при открытии счёта
     * @return созданный объект Account c информацией, записанной в базу данных
     */
    @Override
    public Account openBankAccount(Customer forCustomer, boolean createCard) {
        //Нужно реализовать
        return null;
    }

    /**
     * Добавляет карту к счёту в банке
     * @param accountNumber - номер счёта
     */
    @Override
    public void addCardToAccount(long accountNumber) {
        //Нужно реализовать
    }

    /**
     * Запрашивает баланс счёта по номеру счёта
     * @param accountNumber - номер счета
     * @return остаток на счёте
     */
    @Override
    public BigDecimal getBalanceWithAccountId(long accountNumber) {
        //Нужно реализовать
        return null;
    }

    /**
     * Запрашивает баланс счёта по номеру карты
     * @param cardNumber - номер карты
     * @return остаток на счёте
     */
    @Override
    public BigDecimal getBalanceWithCardNumber(long cardNumber) {
        //Нужно реализовать
        return null;
    }
}
