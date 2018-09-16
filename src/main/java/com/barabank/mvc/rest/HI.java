package com.barabank.mvc.rest;

import com.barabank.mvc.rest.Enumerators.TransactionStatus;
import com.barabank.mvc.rest.beans.TransactionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class HI {
    public static void main(String[] args) {
        ObjectMapper jackson = new ObjectMapper();
        TransactionResponse response = new TransactionResponse();
        response.setMessage("HELLOWORLD!!@!#!#");
        response.setTransactionStatus(TransactionStatus.SUCCESSFUL);

        try {

            System.out.println(jackson.writeValueAsString(response));
            String string = jackson.writeValueAsString(response);
            TransactionResponse response1 = jackson.readValue(string,TransactionResponse.class);
            System.out.println(response1.toString());

        } catch (IOException ex) {
        }


    }
}
