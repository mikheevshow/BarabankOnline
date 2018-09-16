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

        TransactionResponse response1 = new TransactionResponse();
        try {

            System.out.println(jackson.writeValueAsString(response));
            String string = jackson.writeValueAsString(response);
            response1 = (TransactionResponse) jackson.readValue(string, TransactionResponse.class);

        } catch (IOException ex) {


        }

        response1.toString();


    }
}
