package com.barabank.mvc.rest;

import com.barabank.beans.Transaction;
import com.barabank.mvc.rest.beans.TransactionRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;


//@org.springframework.web.bind.annotation.RestController
//@RequestMapping("/webbanking")
//public class RestController {
//
//    @RequestMapping(value = "/{uniq_bank_id}", method = RequestMethod.GET)
//    public void  getFunds(@PathVariable(value = "uniq_bank_id") String uniqBankId, HttpRe) {
//        //1) В теле запроса приходит JSON^
//        String jsonString;
//        //Нужно размапить эту строку в объект TransactonRequest
//        ObjectMapper objectMapper = new ObjectMapper();
//        TransactionRequest transactionRequest = objectMapper.readValues(jsonString, TransactionRequest.class)
//
//    }
//
//    private boolean approveOperation(String jsonString) {
//        return true;
//    }
//
//    private boolean refillOperation(String jsonString) {
//        return true;
//    }
//
//}
