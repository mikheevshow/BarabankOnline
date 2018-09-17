package com.barabank.mvc.site;

import com.barabank.mvc.site.util.SessionChecker;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexPageController {


    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public ModelAndView getIndexPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("funds-transaction-template-2");
        modelAndView.addObject("signInSingOut",SessionChecker.sessionCheck(request));
        modelAndView.addObject("transactionResultMessage", "Операция успешно проведена!");
        return modelAndView;
    }





}
