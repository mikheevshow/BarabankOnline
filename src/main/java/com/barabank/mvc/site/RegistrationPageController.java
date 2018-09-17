package com.barabank.mvc.site;


import com.barabank.beans.Customer;
import com.barabank.beans.Person;
import com.barabank.mvc.site.util.SessionChecker;
import com.barabank.service.logic.BankAccountService;
import com.barabank.service.logic.BankUserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;


@Controller
public class RegistrationPageController {

    @Resource
    private BankUserService bankUserService;

    @Resource
    private BankAccountService accountService;

    public BankUserService getBankUserService() {
        return bankUserService;
    }

    public void setBankUserService(BankUserService bankUserService) {
        this.bankUserService = bankUserService;
    }

    public BankAccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(BankAccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView indexPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if(request.getSession(false)==null) {
            modelAndView.addObject("signInSingOut", SessionChecker.sessionCheck(request));
            modelAndView.setViewName("registration");
            return modelAndView;
        } else {
            modelAndView.setViewName("redirect:/account");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public ModelAndView  getRegistrationFormData(@RequestBody MultiValueMap<String, String> formData,HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        System.out.println(formData.getFirst("first-name").trim());
        System.out.println(formData.getFirst("second-name").trim());
        System.out.println(formData.getFirst("middle-name").trim());
        System.out.println(formData.getFirst("passportId").trim());
        System.out.println(formData.getFirst("phone").trim());
        System.out.println(formData.getFirst("birth-day"));
        System.out.println(formData.getFirst("address").trim());
        System.out.println(formData.getFirst("password").trim());
        System.out.println(formData.getFirst("repeat-password").trim());
        System.out.println(formData.getFirst("password").trim().equals(formData.getFirst("repeat-password").trim()));

        if(formData.getFirst("first-name").trim().length()!=0 && formData.getFirst("second-name").trim().length()!=0 &&
                formData.getFirst("middle-name").trim().length()!=0 && formData.getFirst("passportId").trim().length()!=0 &&
                formData.getFirst("phone").trim().length()!=0 && formData.getFirst("address").trim().length()!=0 &&
                formData.getFirst("password").trim().length()!=0 && formData.getFirst("repeat-password").trim().length()!=0 &&
                (formData.getFirst("password").trim().equals(formData.getFirst("repeat-password").trim()))){

            Person person = new Person();
            person.setFirstName(formData.getFirst("first-name"));
            person.setLastName(formData.getFirst("second-name"));
            person.setMiddleName(formData.getFirst("middle-name"));
            person.setPassportId(Long.parseLong(formData.getFirst("passportId")));
            person.setAddress(formData.getFirst("address"));
            person.setBirthDate(LocalDate.parse(formData.getFirst("birth-day")));
            person.setPhone(Long.parseLong(formData.getFirst("phone")));

            Customer customer = new Customer();
            customer.setPassword(formData.getFirst("password"));
            customer.setPhone(Long.parseLong(formData.getFirst("phone")));


            customer.setPerson(person);
            person.setCustomer(customer);

            System.out.println(customer.toString());
            System.out.println(person.toString());

            bankUserService.addNewUser(customer,person);
            accountService.openBankAccountFor(customer);

            request.getSession().setAttribute("customer",customer);
            request.getSession().setAttribute("person",person);

            modelAndView.setViewName("redirect:/account");
            return modelAndView;

        }else {
            modelAndView.setViewName("registration");
            return modelAndView;
        }
    }

}
