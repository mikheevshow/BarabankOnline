package com.barabank.mvc.site;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexPageController {

    @RequestMapping(method = RequestMethod.GET)
    public String getIndexPage(Model model) {
        return "index";
    }
}
