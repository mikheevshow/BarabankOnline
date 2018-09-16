package com.barabank.mvc.site;


import com.barabank.beans.Customer;
import com.barabank.beans.Person;
import com.barabank.mvc.site.util.SessionChecker;
import com.barabank.service.logic.BankUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller

public class RegistrationPageController {

    @Resource
    private BankUserService bankUserService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView indexPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("signInSingOut", SessionChecker.sessionCheck(request));
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public void getRegistrationFormData(@RequestBody MultiValueMap<String, String> formData) {
        //Валидирование данных
        //После валидирования

        Person person = new Person();
        person.setFirstName(formData.getFirst("first-name"));
        person.setLastName(formData.getFirst("second-name"));
        person.setMiddleName(formData.getFirst("middle-name"));
        person.setAddress(formData.getFirst("address"));
        person.setPassportId(Long.parseLong(formData.getFirst("ID")));
        person.setPhone(Long.parseLong(formData.getFirst("telephone")));

        Customer customer = new Customer();
        customer.setPhone(person.getPhone());
        customer.setPassword(formData.getFirst("password"));




        bankUserService.addNewUser(customer, person);

    }

}
