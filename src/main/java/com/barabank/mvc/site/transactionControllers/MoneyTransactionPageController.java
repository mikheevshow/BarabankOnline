package com.barabank.mvc.site.transactionControllers;


import com.barabank.beans.Account;
import com.barabank.beans.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/money-transactions")
public class MoneyTransactionPageController {

    @RequestMapping(method = RequestMethod.GET)
    public String moneyTransactionPage() {
        return "funds-operations-selector";
    }

    @RequestMapping(value = "/self-transactions", method = RequestMethod.GET)
    public ModelAndView returnSelfTransactionPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("funds-transaction-template-1");
        return modelAndView;
    }

    @RequestMapping(value = "/self-bank-transactions", method = RequestMethod.GET)
    public String returnBankSelfTransactionPage() {
        return "funds-transaction-template-2";
    }

    @RequestMapping(value = "/outer-bank-transactions", method = RequestMethod.GET)
    public String returnOtherBankTransactionPage() {
        return "funds-transaction-template-3";
    }

    @RequestMapping(value = "/self-transactions", method = RequestMethod.POST)
    public ModelAndView SelfTransaction() {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @RequestMapping(value = "/self-bank-transactions", method = RequestMethod.POST)
    public ModelAndView BankSelfTransaction() {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @RequestMapping(value = "/outer-bank-transactions", method = RequestMethod.POST)
    public ModelAndView OtherBankTransaction() {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @RequestMapping(value = "/banktransaction/accounts", method = RequestMethod.GET)
    @ResponseBody
    public String returnAccountList(HttpServletRequest request) {

        Customer customer = (Customer) request.getSession(false).getAttribute("customer");
        List<Account> accounts = customer.getAccounts();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(accounts);
            return json;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "0";
    }

}
