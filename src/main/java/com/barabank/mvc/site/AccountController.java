package com.barabank.mvc.site;

import com.barabank.beans.Customer;
import com.barabank.beans.Person;
import com.barabank.service.enums.TransactionReportType;
import com.barabank.service.logic.BankTransactionReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Resource
    BankTransactionReportService bankTransactionReportService;

    public BankTransactionReportService getBankTransactionReportService() {
        return bankTransactionReportService;
    }

    public void setBankTransactionReportService(BankTransactionReportService bankTransactionReportService) {
        this.bankTransactionReportService = bankTransactionReportService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView privateAccountPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession(false);
        if(session == null) {
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        } else {

            Person person = (Person) session.getAttribute("person");
            Customer customer = (Customer) session.getAttribute("customer");

            //Устанавливаем параметры пользователя
            modelAndView.addObject("first-name", person.getFirstName());
            modelAndView.addObject("second-name", person.getLastName());
            modelAndView.addObject("middle-name", person.getMiddleName());

            modelAndView.addObject("transactions", bankTransactionReportService.getAllTransactionsForCustomer(customer, TransactionReportType.JSON));



            modelAndView.setViewName("account");
            return modelAndView;
        }
    }
}
