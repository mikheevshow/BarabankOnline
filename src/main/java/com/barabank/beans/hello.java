package com.barabank.beans;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

public class hello {



    public static void main(String[] args) throws IOException {

        BigDecimal a = BigDecimal.valueOf(42342L);

        Transaction transaction = new Transaction();
        transaction.setFromAccount(465746L);
        transaction.setToAccount(7342785L);
        transaction.setSum(a);
        transaction.setId(1234L);

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(transaction);

        System.out.println(jsonString);

    }

}
