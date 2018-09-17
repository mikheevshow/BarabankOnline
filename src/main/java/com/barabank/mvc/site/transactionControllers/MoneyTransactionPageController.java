package com.barabank.mvc.site.transactionControllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/money-transactions")
public class MoneyTransactionPageController {

    @RequestMapping(method = RequestMethod.GET)
    public String moneyTransactionPage() {
        return "funds-operations-selector";
    }

    @RequestMapping(value = "/self-transactions", method = RequestMethod.GET)
    public String returnSelfTransactionPage() {
        return "funds-transaction-template-1";
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

}
