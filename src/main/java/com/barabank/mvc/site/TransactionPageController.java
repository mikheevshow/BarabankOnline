package com.barabank.mvc.site;


import com.barabank.beans.Customer;
import com.barabank.service.logic.BankTransactionReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/account/transactions")
public class TransactionPageController {

    @Resource
    private BankTransactionReportService transactionReportService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView returnJsonTransactionString(Model model, HttpServletRequest request) {
        Customer customer = (Customer) request.getSession(false).getAttribute("customer");
        return null;
    }

}
