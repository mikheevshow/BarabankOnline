package com.barabank.mvc.rest;

import com.barabank.beans.Transaction;
import com.barabank.mvc.rest.beans.TransactionRequest;
import com.fasterxml.jackson.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RequestMapping("/webbanking")
public class RestController {

    @RequestMapping(value = "/{uniq_bank_id}", method = RequestMethod.GET)
    public void  getFunds(@PathVariable(value = "uniq_bank_id") String uniqBankId, @RequestBody MultiValueMap<String,String> requestBody) {
        if (requestBody != null) {
            String jsonString = requestBody.getFirst("transaction_request");
            ObjectMapper objectMapper = new ObjectMapper();
            TransactionRequest transactionRequest = null;
            try {
                transactionRequest = objectMapper.readValue(jsonString, TransactionRequest.class);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/{uniq_bank_id}/{transaction_key}", method = RequestMethod.GET)
    public void operationApproving(@PathVariable("uniq_bank_id") String uniqBankId, @PathVariable("transaction_key") String transactionKey, @RequestBody MultiValueMap<String,String> requestBody) {

    }

}
