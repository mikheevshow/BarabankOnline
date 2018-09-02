package com.barabank.mvc.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/webbanking")
public class RestController {
    @RequestMapping(value = "/{bank_id}/{user_id}/{account_number}/{sum}/{request_type}", method = RequestMethod.GET)
    public void getOtherBankRequest() {
        //Тут обрабатываем рест запрос из другого банка
    }
    //Короче тут нужно придумать типы запрорсов request_type
    //Например: send, recive
}
