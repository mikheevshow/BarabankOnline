package com.barabank.service.logic;

import com.barabank.beans.Customer;
import com.barabank.service.exceptions.UserNotExistException;

public interface UserService {

    public Customer findCustomerByPhone(long phone) throws UserNotExistException;

}
