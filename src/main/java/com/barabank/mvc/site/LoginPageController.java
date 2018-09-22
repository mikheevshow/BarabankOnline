package com.barabank.mvc.site;

import com.barabank.beans.Customer;
import com.barabank.beans.Person;
import com.barabank.mvc.site.util.SessionChecker;
import com.barabank.service.exceptions.UserNotExistException;
import com.barabank.service.logic.BankUserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginPageController {

   @Resource
   private BankUserService service;

    public BankUserService getService() {
        return service;
    }

    public void setService(BankUserService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView loginPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if(request.getSession(false)==null) {
            modelAndView.setViewName("login");
            modelAndView.addObject("signInSingOut", SessionChecker.sessionCheck(request));
            return modelAndView;
        } else {
            modelAndView.setViewName("redirect:/account");
            return modelAndView;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public String authentication(@RequestBody MultiValueMap<String, String> formData, HttpServletRequest request) {
        if((formData.getFirst("phone").trim().length()!=0 && formData.getFirst("password").trim().length()!=0)) {
            long phone = Long.parseLong(formData.getFirst("phone"));
            Customer customer;
            try {
                System.out.println("Try to find person");
                customer = service.findCustomerByPhone(phone);
                if (customer.getPassword().equals(formData.getFirst("password"))) {
                    request.getSession().setAttribute("customer", customer);
                    request.getSession().setAttribute("person", customer.getPerson());
                    System.out.println("//////login//////");
                    return "redirect:/account";
                }
                else{
                    return "login";
                }
            } catch (UserNotExistException ex) {
                return "login";
            }
        }
        return "login";
    }
}
