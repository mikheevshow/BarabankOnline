package com.barabank.mvc.site;


import com.barabank.beans.Customer;
import com.barabank.beans.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller

public class RegistrationPageController {

    @Resource
    private OnlineBankInterface service;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String indexPage(Model model) {
        System.out.println("Страница открыта");
        return "registration";
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
        person.setId(Long.parseLong(formData.getFirst("ID")));
        person.setPhone(Long.parseLong(formData.getFirst("telephone")));

        Customer customer = new Customer();
        customer.setPhone(person.getPhone());
        customer.setPassword(formData.getFirst("password"));


        service.addPerson(person);
        service.addCustomer(customer);

    }

}
