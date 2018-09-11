package com.barabank.mvc.rest;

import com.barabank.service.logic.BankService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.BigInteger;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/webbanking")
public class RestController {
//
//    @Resource
//    private static final BankService service;
//
//    @RequestMapping(value = "/{bank_id}/{user_id}/{account_number}/{sum}/{req}", method = RequestMethod.GET)
//    @ResponseBody
//    public void getBankRequest(@PathVariable("bank_id") String bankId, @PathVariable("user_id") long userId, @PathVariable("account_number") long accountNumber, @PathVariable("sum")BigInteger sum, @PathVariable("req") String req) {
//
//        if (req.equals("request")) {
//
//
//
//        } else if (req.equals("accept")) {
//
//
//
//        } else {
//
//        }
//
//    }
}
