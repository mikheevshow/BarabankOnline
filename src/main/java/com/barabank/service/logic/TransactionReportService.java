package com.barabank.service.logic;

import com.barabank.beans.Customer;
import com.barabank.beans.Transaction;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public interface TransactionReportService {

    public String getBankTransactionsForPeriod(Period period, TransactionReportType transactionReportType);
    public String getBankTransactionsForDay(LocalDate date, TransactionReportType transactionReportType);

    public String getTransactionsForCustomerInPeriod(Customer customer, Period period, TransactionReportType transactionReportType);
    public String getTransactionsForCustomerInDate(Customer customer, LocalDate date, TransactionReportType transactionReportType);

    public String getTransactionsForAccountInPeriod(long account, LocalDateTime startTime, LocalDateTime endTime, TransactionReportType transactionReportType);
    public String getTransactionsForAccountInDate(long account, LocalDateTime date, TransactionReportType transactionReportType);

}
