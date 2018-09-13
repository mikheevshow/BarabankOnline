package com.barabank.mvc.site;

import com.barabank.beans.Customer;
import com.barabank.beans.Person;
import com.barabank.service.exceptions.UserNotExistException;
import com.barabank.service.logic.BankUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginPageController {

   @Resource
   private BankUserService service;

    @RequestMapping(method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String authentication(@RequestBody MultiValueMap<String, String> formData, HttpServletRequest request) {

        long phone = Long.parseLong(formData.getFirst("telephone"));

        Customer customer;
        Person person;

        try {
            customer = service.findCustomerByPhone(phone);
            if (customer.getPassword().equals(formData.getFirst("password"))) {
                person = service.findPersonByPhone(phone);
                request.getSession().setAttribute("customer", customer);
                request.getSession().setAttribute("person", person);
            }
            return "redirect:/account";
        } catch (UserNotExistException ex) {
            ex.printStackTrace();
            return "login";
        }
    }
}
