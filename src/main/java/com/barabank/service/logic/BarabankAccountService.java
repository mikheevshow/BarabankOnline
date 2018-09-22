package com.barabank.service.logic;

import com.barabank.beans.Account;
import com.barabank.beans.BankCard;
import com.barabank.beans.Customer;
import com.barabank.dao.BankDao;
import com.barabank.service.enums.BankCardPaymentSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author Ilya Mikheev
 * @author Leonid Zemenkov
 */

@Service
public class BarabankAccountService implements BankAccountService {

    private BankDao bankDao;

    @Autowired
    public BarabankAccountService(BankDao bankDao) {
        this.bankDao = bankDao;
    }



    /**
     * Открывает новый счет для клиента банка
     * @param customer - клиент банка
     * @return созданный объект Account c информацией, записанной в базу данных
     */
    @Override
    public Account openBankAccountFor(Customer customer) {
        return bankDao.addAccountForCustomer(customer);
    }

    /**
     * Добавляет карту к счёту в банке
     * @param accountNumber - номер счёта
     * @param bankCardPaymentSystem - тип платежной системы, которая поддерживается картой
     */
    @Override
    public void addCardToAccount(long accountNumber, BankCardPaymentSystem bankCardPaymentSystem) {
        Account account = bankDao.findAccountById(accountNumber);
        BankCard bankCard = new BankCard();
        bankCard.setPaymentSystem(bankCardPaymentSystem);
        Collection<BankCard> bankCardCollection = new HashSet<>();
        bankCardCollection.add(bankCard);
        account.addBankCards(bankCardCollection);
        bankDao.updateAccount(account);
    }

    /**
     * Запрашивает баланс счёта по номеру счёта
     * @param accountNumber - номер счета
     * @return остаток на счёте
     */
    @Override
    public BigDecimal getBalanceWithAccountId(long accountNumber) {
        return bankDao.findAccountById(accountNumber).getBalance();
    }

    /**
     * Запрашивает баланс счёта по номеру карты
     * @param cardNumber - номер карты
     * @return остаток на счёте
     */
    @Override
    public BigDecimal getBalanceWithCardNumber(long cardNumber) {
        return bankDao.findAccountByCardNumber(cardNumber).getBalance();
    }
}
