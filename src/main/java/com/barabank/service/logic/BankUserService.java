package com.barabank.service.logic;

import com.barabank.beans.Customer;
import com.barabank.beans.Person;
import com.barabank.service.exceptions.UserNotExistException;

public interface BankUserService {

    public Customer findCustomerByPhone(long phone) throws UserNotExistException;

    public Person findPersonById(long id) throws UserNotExistException;

    public Person findPersonByPhone(long phone) throws UserNotExistException;

    public void addPerson(Person person);

    public void addCustomer(Customer customer);

}
