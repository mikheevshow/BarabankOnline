package com.barabank.mvc.rest;

import com.barabank.beans.Transaction;
import com.barabank.mvc.rest.beans.TransactionRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/webbanking")
public class RestController {

    @RequestMapping(value = "/{uniq_bank_id}", method = RequestMethod.GET)
    public void  getFunds(@PathVariable(value = "uniq_bank_id") String uniqBankId, @RequestBody MultiValueMap<String,String> requestBody) {
        if (requestBody != null) {
            String jsonString = (String) requestBody.getFirst("transaction_request");
            ObjectMapper objectMapper = new ObjectMapper();
            TransactionRequest transactionRequest = objectMapper.readValues(jsonString)
        }
    }

    @RequestMapping(value = "/{uniq_bank_id}/{transaction_key}", method = RequestMethod.GET)
    public void operationApproving(@PathVariable(value = "uniq_bank_id") String uniqBankId, @PathVariable(value = "transaction_key") String transactionKey) {

    }

}
