package com.barabank.mvc.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/deauthentication")
public class DeauthenticationController {

    @RequestMapping(method = RequestMethod.GET)
    public String deauthentication(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/index";
    }
}
