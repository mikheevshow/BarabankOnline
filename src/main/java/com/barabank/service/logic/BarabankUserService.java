package com.barabank.service.logic;

import com.barabank.beans.Customer;
import com.barabank.beans.Person;
import com.barabank.dao.BankDao;
import com.barabank.service.exceptions.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;

public class BarabankUserService implements BankUserService {

    private BankDao bankDao;

    private BankDao getBankDao() {
        return bankDao;
    }

    @Autowired
    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    @Override
    public Customer findCustomerByPhone(long phone) throws UserNotExistException {
        Customer customer = getBankDao().findCustomerByPhone(phone);
        if (customer != null) {
            return customer;
        } else {
            throw new UserNotExistException("Клиент с номером" + phone + "не найден");
        }
    }

    @Override
    public Person findPersonById(long id) throws UserNotExistException {
        Person person = getBankDao().findPersonWithPassportID(id);
        if (person != null) {
            return person;
        } else {
            throw new UserNotExistException("Пользователь не найден");
        }
    }

    @Override
    public Person findPersonByPhone(long phone) throws UserNotExistException {
        Person person = getBankDao().findPersonByPhone(phone);
        if (person != null) {
            return person;
        } else {
            throw new UserNotExistException("Пользователь с номером  " + phone + " не найден");
        }
    }

    @Override
    public void addPerson(Person person) {

    }

    @Override
    public void addCustomer(Customer customer) {

    }
}
