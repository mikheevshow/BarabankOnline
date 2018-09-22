package com.barabank.mvc.site;

import com.barabank.beans.Customer;
import com.barabank.beans.Person;
import com.barabank.mvc.site.util.SessionChecker;
import com.barabank.service.enums.TransactionReportType;
import com.barabank.service.logic.BankTransactionReportService;
import com.barabank.service.logic.BarabankUserService;
import org.springframework.stereotype.Controller;
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
    BarabankUserService barabankUserService;

    @Resource
    BankTransactionReportService bankTransactionReportService;


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

            customer = barabankUserService.findCustomerByPhone(customer.getPhone());
            person=customer.getPerson();

            String accountHolderName = person.getFirstName() + " " + person.getMiddleName() + " " + person.getLastName();

            modelAndView.setViewName("account");

            //Устанавливаем параметры пользователя
            modelAndView.addObject("accountHolderName", accountHolderName);
            modelAndView.addObject("birthDate", person.getBirthDate().toString());
            modelAndView.addObject("phone", customer.getPhone());

            modelAndView.addObject("transactions", bankTransactionReportService.getAllTransactionsForCustomer(customer, TransactionReportType.JSON));
            modelAndView.addObject("signInSingOut", SessionChecker.sessionCheck(request));
            modelAndView.addObject("accountsJson",customer.getAccounts().toString());

            modelAndView.addObject("transactionJSON",bankTransactionReportService.getAllTransactionsForCustomer(customer,TransactionReportType.JSON));

            return modelAndView;
        }
    }
}
