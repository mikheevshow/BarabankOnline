package com.barabank.mvc.site;

import com.barabank.beans.Customer;
import com.barabank.service.exceptions.AccountNumberExeption;
import com.barabank.service.logic.BankTransactionService;
import com.barabank.service.logic.BarabankTransactionService;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.Resource;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Controller
@RequestMapping("/refill")
public class RefillController {

    @Resource
    private BankTransactionService transactionService;

    @RequestMapping(method = RequestMethod.GET)
    public String refillGet(HttpServletRequest request){
        if(request.getSession(false)!=null){
            return "refill";
        } else {
            return "login";
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView refillPost(@RequestBody MultiValueMap<String, String> formData, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        if (formData.getFirst("account_number").trim().length() !=0 && formData.getFirst("sum").trim().length()!=0){
            long accountNumber = Long.parseLong(formData.getFirst("account_number"));
            BigDecimal sum = BigDecimal.valueOf(Long.parseLong(formData.getFirst("sum")));

            HttpSession session = request.getSession(false);
            Customer customer =(Customer) session.getAttribute("customer");
            try{
                transactionService.checkCustomerAccount(customer,accountNumber);
                transactionService.refillAccount(accountNumber,sum);
                modelAndView.addObject("transactionResultMessage","Операция провеена успешно!");
                modelAndView.setViewName("funds-transaction-result");
            } catch (AccountNumberExeption | NoResultException e){
                e.printStackTrace();
                modelAndView.addObject("transactionResultMessage","Неверный номер счета!");
            }
        } else {
            modelAndView.setViewName("refill");
        }
        return modelAndView;
    }


}
