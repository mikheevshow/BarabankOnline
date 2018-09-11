package com.barabank.mvc.site;

import com.barabank.beans.Customer;
import com.barabank.beans.Person;
import org.hibernate.Session;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping(method = RequestMethod.GET)
    public String privateAccountPage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if(session == null) {
            return "redirect:/login";
        } else {
            Person person = (Person) session.getAttribute("person");
            Customer customer = (Customer) session.getAttribute("customer");
            System.out.println(person.getFirstName());
            System.out.println(customer.getId());
            return "account";
        }
    }

}
