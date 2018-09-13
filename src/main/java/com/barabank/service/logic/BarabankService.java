package com.barabank.service.logic;
import com.barabank.beans.*;
import com.barabank.dao.*;
import com.barabank.service.exceptions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Илья Михееа
 * @author Леонид Земенков
 */

@Service
@Transactional
public class BarabankService {

    private BankTransactionService bankTransactionService;

    private BankTransactionReportService bankTransactionReportService;

    private BankAccountService bankAccountService;

    private BankCardOperationService bankCardOperationService;

    public BankTransactionService getBankTransactionService() {
        return bankTransactionService;
    }

    @Autowired
    public void setBankTransactionService(BankTransactionService bankTransactionService) {
        this.bankTransactionService = bankTransactionService;
    }

    public BankTransactionReportService getBankTransactionReportService() {
        return bankTransactionReportService;
    }

    @Autowired
    public void setBankTransactionReportService(BankTransactionReportService bankTransactionReportService) {
        this.bankTransactionReportService = bankTransactionReportService;
    }

    public BankAccountService getBankAccountService() {
        return bankAccountService;
    }

    @Autowired
    public void setBankAccountService(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    public BankCardOperationService getBankCardOperationService() {
        return bankCardOperationService;
    }

    @Autowired
    public void setBankCardOperationService(BankCardOperationService bankCardOperationService) {
        this.bankCardOperationService = bankCardOperationService;
    }
}
