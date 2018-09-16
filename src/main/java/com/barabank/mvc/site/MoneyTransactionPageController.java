package com.barabank.mvc.site;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/money-transactions")
public class MoneyTransactionPageController {

    @RequestMapping(method = RequestMethod.GET)
    public String moneyTransactionPage() {
        return "money-transactions";
    }
}
