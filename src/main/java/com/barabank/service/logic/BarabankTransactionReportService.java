package com.barabank.service.logic;

import com.barabank.beans.*;
import com.barabank.dao.BankDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Ilya Mikheev
 * @author Leonid Zemenkov
 */

@Service
public class BarabankTransactionReportService implements BankTransactionReportService {

    private BankDao bankDao;

    private BankDao getBankDao() {
        return bankDao;
    }

    @Autowired
    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    /**
     * Метод получения списка банковских транзакций за некоторый период
     * @param startDate - начальная дата
     * @param endDate - конечная дата
     * @param transactionReportType - формат данных
     * @return строка Json или XML
     */
    public String getBankTransactionsForPeriod(LocalDate startDate, LocalDate endDate, TransactionReportType transactionReportType) {
        List<Transaction> bankTransactions = getBankDao().findAllTransactions();
        for (Transaction transaction: bankTransactions) {
            if (transaction.getDate().toLocalDate().isAfter(endDate) || transaction.getDate().toLocalDate().isBefore(startDate)) {
                bankTransactions.remove(transaction);
            }
        }
        return JsonXmlParser(bankTransactions, transactionReportType);
    }

    /**
     * Метод получения списка банковских транзакций за передаваемую дату
     * @param date - дата за которую нужно получить список транзакций
     * @param transactionReportType - формат данных
     * @return строка Json или XML
     */
    public String getBankTransactionsForDay(LocalDate date, TransactionReportType transactionReportType) {
        List<Transaction> bankTransactions = getBankDao().findAllTransactions();
        for (Transaction transaction: bankTransactions) {
            if (transaction.getDate().toLocalDate() == date) {
                bankTransactions.remove(transaction);
            }
        }
        return JsonXmlParser(bankTransactions, transactionReportType);
    }

    /**
     * Метод получения списка банковских транзакций за некоторый период
     * для конкретного пользователя по всем счетам
     * @param customer - пользователь
     * @param startDate - начальная дата
     * @param endDate - конечная дата
     * @param transactionReportType - формат данных
     * @return строка Json или XML
     */
    public String getTransactionsForCustomerInPeriod(Customer customer, LocalDate startDate, LocalDate endDate, TransactionReportType transactionReportType) {
        List<Account> customerAccountList = customer.getAccounts();
        List<Transaction> customerTransactions = new ArrayList<>();
        long accountId;
        for (Account account: customerAccountList) {
            accountId = account.getId();
            customerTransactions.addAll(getBankDao().findAllTransactionsForAccount(accountId));
        }
        for (Transaction transaction: customerTransactions) {
            if (transaction.getDate().toLocalDate().isAfter(endDate) || transaction.getDate().toLocalDate().isBefore(startDate)) {
                customerTransactions.remove(transaction);
            }
        }
        return JsonXmlParser(customerAccountList, transactionReportType);
    }

    /**
     * Метод получения списка банковских транзакций за передаваемую дату
     * для конкретного пользователя по всем счетам
     * @param customer - пользователь
     * @param date - дата за которую нужно получить список транзакций
     * @param transactionReportType - формат данных
     * @return строка Json или XML
     */
    public String getTransactionsForCustomerInDate(Customer customer, LocalDate date, TransactionReportType transactionReportType) {
        List<Account> customerAccountList = customer.getAccounts();
        List<Transaction> customerTransactions = new ArrayList<>();
        long accountId;
        for (Account account: customerAccountList) {
            accountId = account.getId();
            customerTransactions.addAll(getBankDao().findAllTransactionsForAccount(accountId));
        }
        for (Transaction transaction: customerTransactions) {
            if (transaction.getDate().toLocalDate() == date) {
                customerTransactions.remove(transaction);
            }
        }
        return JsonXmlParser(customerTransactions, transactionReportType);
    }

    /**
     * Метод получения списка банковских транзакций за некоторый период
     * для конкретного банковского счета
     * @param account - номер счета
     * @param startDate - начальная дата
     * @param endDate - конечная дата
     * @param transactionReportType - формат данных
     * @return строка Json или XML
     */
    public String getTransactionsForAccountInPeriod(long account, LocalDate startDate, LocalDate endDate, TransactionReportType transactionReportType) {
        List<Transaction> accountTransactions = new ArrayList<>(getBankDao().findAllTransactionsForAccount(account));
        for (Transaction transaction: accountTransactions) {
            if (transaction.getDate().toLocalDate().isAfter(endDate) || transaction.getDate().toLocalDate().isBefore(startDate)) {
                accountTransactions.remove(transaction);
            }
        }
        return JsonXmlParser(accountTransactions, transactionReportType);
    }

    /**
     * Метод получения списка банковских транзакций за передаваемую дату
     * для конкретного банковского счета
     * @param account - номер счета
     * @param date - дата за которую нужно получить список транзакций
     * @param transactionReportType - формат данных
     * @return строка Json или XML
     */
    public String getTransactionsForAccountInDate(long account, LocalDate date, TransactionReportType transactionReportType) {
        List<Transaction> accountTransactions = new ArrayList<>(getBankDao().findAllTransactionsForAccount(account));
        for (Transaction transaction: accountTransactions) {
            if (transaction.getDate().toLocalDate() == date) {
                accountTransactions.remove(transaction);
            }
        }
        return JsonXmlParser(accountTransactions, transactionReportType);
    }

    /**
     * Private метод, заключающий в себе шаблонный код для маршаллинга данных о транзакциях
     * @param collection - коллекция объектов для Json/XML маршаллинга
     * @param transactionReportType - формат данных
     * @return строка Json или XML
     */
    private String JsonXmlParser(Collection collection, TransactionReportType transactionReportType) {

        if (transactionReportType == TransactionReportType.JSON) {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString;
            try {
                jsonString = mapper.writeValueAsString(collection);
                return jsonString;
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
                return null;
            }

        } else if (transactionReportType == TransactionReportType.XML) {
            return null;
        }

        return null;
    }
}
