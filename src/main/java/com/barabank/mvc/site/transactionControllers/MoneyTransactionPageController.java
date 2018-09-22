package com.barabank.mvc.site.transactionControllers;


import com.barabank.beans.Account;
import com.barabank.beans.Customer;
import com.barabank.service.exceptions.InsufficientFundsException;
import com.barabank.service.logic.BankTransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/money-transactions")
public class MoneyTransactionPageController {

    @Resource
    BankTransactionService transactionService;

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
    public ModelAndView SelfTransaction(@RequestBody MultiValueMap<String, String> formData) {
        ModelAndView modelAndView = new ModelAndView();

        if(formData.getFirst("sender_account").trim().length()!=0 &&
            formData.getFirst("reciver_account").trim().length()!=0 &&
            formData.getFirst("sum").trim().length()!=0) {

            long senderAccount = Long.parseLong(formData.getFirst("sender_account"));
            long reciverAccount = Long.parseLong(formData.getFirst("reciver_account"));
            BigDecimal sum = BigDecimal.valueOf(Long.parseLong(formData.getFirst("sum")));
            try{
                transactionService.transferMoney(senderAccount,reciverAccount,sum);
                modelAndView.addObject("transactionResultMessage","Операция провеена успешно!");
            } catch (InsufficientFundsException e){
                e.printStackTrace();
                modelAndView.addObject("transactionResultMessage",e.getMessage());
            }

            modelAndView.setViewName("funds-transaction-result");
            return modelAndView;
        } else {
            modelAndView.setViewName("redirect:/money-transactions/self-transactions");
            return modelAndView;
        }
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
        System.out.println(accounts.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        String json;

        return accounts.toString();
    }

}
