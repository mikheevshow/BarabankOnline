package com.barabank.service.logic;

import com.barabank.beans.Customer;
import com.barabank.dao.BankDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BarabankTransactionReportService implements TransactionReportService {

    private BankDao bankDao;

    public BankDao getBankDao() {
        return bankDao;
    }

    @Autowired
    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    public String getBankTransactionsForPeriod(Period period, TransactionReportType transactionReportType) {
        // Логика по созданию колекции транзакций
        return JsonXmlParser(transactionReportType);
    }


    public String getBankTransactionsForDay(LocalDate date, TransactionReportType transactionReportType) {
        // Логика по созданию колекции транзакций
        return JsonXmlParser(transactionReportType);
    }


    public String getTransactionsForCustomerInPeriod(Customer customer, Period period, TransactionReportType transactionReportType) {

        // Логика по созданию колекции транзакций
        return JsonXmlParser(transactionReportType);
    }


    public String getTransactionsForCustomerInDate(Customer customer, LocalDate date, TransactionReportType transactionReportType) {
        // Логика по созданию колекции транзакций
        return JsonXmlParser(transactionReportType);
    }


    public String getTransactionsForAccountInPeriod(long account, Period period, TransactionReportType transactionReportType) {
        // Логика по созданию колекции транзакций
        return JsonXmlParser(transactionReportType);
    }


    public String getTransactionsForAccountInDate(long account, LocalDate date, TransactionReportType transactionReportType) {
        // Логика по созданию колекции транзакций
        return JsonXmlParser(transactionReportType);
    }

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
