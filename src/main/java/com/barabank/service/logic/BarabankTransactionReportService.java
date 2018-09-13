//package com.barabank.service.logic;
//
//import com.barabank.beans.*;
//import com.barabank.dao.BankDao;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.Period;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
///**
// * @author Ilya Mikheev
// * @author Leonid Zemenkov
// */
//
//@Service
//public class BarabankTransactionReportService implements TransactionReportService {
//
//    private BankDao bankDao;
//
//    private BankDao getBankDao() {
//        return bankDao;
//    }
//
//    @Autowired
//    public void setBankDao(BankDao bankDao) {
//        this.bankDao = bankDao;
//    }
//
//    /**
//     * Метод получения списка банковских транзакций за некоторый период
//     * @param period - период, за который нужно получить список транзакций
//     * @param transactionReportType - формат данных
//     * @return строка Json или XML
//     */
//
//    public String getBankTransactionsForPeriod(Period period, TransactionReportType transactionReportType) {
//        List<Transaction> bankTransactions = new ArrayList<>();
//        // Логика по созданию колекции транзакций
//        return JsonXmlParser(bankTransactions, transactionReportType);
//    }
//
//    /**
//     * Метод получения списка банковских транзакций за передаваемую дату
//     * @param date - дата за которую нужно получить список транзакций
//     * @param transactionReportType - формат данных
//     * @return строка Json или XML
//     */
//    public String getBankTransactionsForDay(LocalDate date, TransactionReportType transactionReportType) {
//        List<Transaction> bankTransactions = new ArrayList<>();
//        // Логика по созданию колекции транзакций
//        return JsonXmlParser(bankTransactions, transactionReportType);
//    }
//
//
//    /**
//     * Метод получения списка банковских транзакций за некоторый период
//     * для конкретного пользователя по всем счетам
//     * @param customer - пользователь
//     * @param period - период, за который нужно получить список транзакций
//     * @param transactionReportType - формат данных
//     * @return строка Json или XML
//     */
//    public String getTransactionsForCustomerInPeriod(Customer customer, Period period, TransactionReportType transactionReportType) {
//        List<Account> customerAccountList = customer.getAccounts();
//        List<Transaction> customerTransactions = new ArrayList<>();
//        long accountId;
//        for (Account account: customerAccountList) {
//            accountId = account.getId();
//            customerTransactions.addAll();
//        }
//        // Логика по созданию колекции транзакций
//        return JsonXmlParser(customerAccountList, transactionReportType);
//    }
//
//    /**
//     * Метод получения списка банковских транзакций за передаваемую дату
//     * для конкретного пользователя по всем счетам
//     * @param customer - пользователь
//     * @param date - дата за которую нужно получить список транзакций
//     * @param transactionReportType - формат данных
//     * @return строка Json или XML
//     */
//    public String getTransactionsForCustomerInDate(Customer customer, LocalDate date, TransactionReportType transactionReportType) {
//        List<Transaction> customerTransactions = new ArrayList<>();
//        // Логика по созданию колекции транзакций
//        return JsonXmlParser(customerTransactions, transactionReportType);
//    }
//
//    /**
//     * Метод получения списка банковских транзакций за некоторый период
//     * для конкретного банковского счета
//     * @param account - номер счета
//     * @param period - период, за который нужно получить список транзакций
//     * @param transactionReportType - формат данных
//     * @return строка Json или XML
//     */
//    public String getTransactionsForAccountInPeriod(long account, LocalDateTime startTime, LocalDateTime endTime, TransactionReportType transactionReportType) {
//
//        List<Transaction> accountTransactions = new ArrayList<>();
//        //Получает все транзакции для аккаунта;
//
//        accountTransactions.addAll(getBankDao().findAllTransactionsForAccount(account));
//
//        List<Transaction> t  = new ArrayList<Transaction>();
//
//        LocalDateTime transactionDate;
//
//        for (Transaction transaction:accountTransactions) {
//            transactionDate = transaction.getDate();
//            if (transactionDate.isAfter(startTime) && transactionDate.isBefore(endTime)) {
//                t.add(transaction);
//            }
//        }
//
//        // Логика по созданию колекции транзакций
//        return JsonXmlParser(t, transactionReportType);
//    }
//
//    /**
//     * Метод получения списка банковских транзакций за передаваемую дату
//     * для конкретного банковского счета
//     * @param account - номер счета
//     * @param date - дата за которую нужно получить список транзакций
//     * @param transactionReportType - формат данных
//     * @return строка Json или XML
//     */
//    public String getTransactionsForAccountInDate(long account, LocalDateTime date, TransactionReportType transactionReportType) {
//
//        List<Transaction> accountTransactions = new ArrayList<>();
//        //Получает все транзакции для аккаунта;
//
//        accountTransactions.addAll(getBankDao().findAllTransactionsForAccount(account));
//
//        List<Transaction> t  = new ArrayList<Transaction>();
//
//        for (Transaction transaction:accountTransactions) {
//            if (transaction.getDate().isEqual(date)) {
//                t.add(transaction);
//            }
//        }
//
//        // Логика по созданию колекции транзакций
//        return JsonXmlParser(t, transactionReportType);
//    }
//
//    /**
//     * Private метод, заключающий в себе шаблонный код для маршаллинга данных о транзакциях
//     * @param collection - коллекция объектов для Json/XML маршаллинга
//     * @param transactionReportType - формат данных
//     * @return строка Json или XML
//     */
//    private String JsonXmlParser(Collection collection, TransactionReportType transactionReportType) {
//
//        if (transactionReportType == TransactionReportType.JSON) {
//            ObjectMapper mapper = new ObjectMapper();
//            String jsonString;
//            try {
//                jsonString = mapper.writeValueAsString(collection);
//                return jsonString;
//            } catch (JsonProcessingException ex) {
//                ex.printStackTrace();
//                return null;
//            }
//
//        } else if (transactionReportType == TransactionReportType.XML) {
//            return null;
//        }
//
//        return null;
//    }
//}
