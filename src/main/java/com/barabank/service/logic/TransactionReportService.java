package com.barabank.service.logic;

import com.barabank.beans.Customer;
import com.barabank.beans.Transaction;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public interface TransactionReportService {

    public String getBankTransactionsForPeriod(LocalDate startDate, LocalDate endDate, TransactionReportType transactionReportType);
    public String getBankTransactionsForDay(LocalDate date, TransactionReportType transactionReportType);

    public String getTransactionsForCustomerInPeriod(Customer customer, LocalDate startDate, LocalDate endDate, TransactionReportType transactionReportType);
    public String getTransactionsForCustomerInDate(Customer customer, LocalDate date, TransactionReportType transactionReportType);

    public String getTransactionsForAccountInPeriod(long account, LocalDate startDate, LocalDate endDate, TransactionReportType transactionReportType);
    public String getTransactionsForAccountInDate(long account, LocalDate date, TransactionReportType transactionReportType);

}
