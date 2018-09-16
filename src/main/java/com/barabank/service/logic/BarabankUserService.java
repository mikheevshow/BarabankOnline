package com.barabank.service.logic;

import com.barabank.beans.Customer;
import com.barabank.beans.Person;
import com.barabank.dao.BankDao;
import com.barabank.service.exceptions.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ilya Mikheev
 * @author Leonid Zemenkov
 */

@Service
public class BarabankUserService implements BankUserService {

    private BankDao bankDao;

    private BankDao getBankDao() {
        return bankDao;
    }

    @Autowired
    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    /**
     * Поиск клиента по номеру телефона
     * @param phone - номер телефона клиента
     * @return Customer(Клиент банка)
     * @throws UserNotExistException - генерирует исключение, если клиент не найден
     */
    @Override
    public Customer findCustomerByPhone(long phone) throws UserNotExistException {
        Customer customer = getBankDao().findCustomerByPhone(phone);
        if (customer != null) {
            return customer;
        } else {
            throw new UserNotExistException("Клиент с номером" + phone + "не найден");
        }
    }

    /**
     * Получение персональных данных клиента банка по номеру паспорта
     * @param id - персональные паспортные данные клиента банка
     * @return объект Person, содержащий персональные данные клиента банка
     * @throws UserNotExistException - генерирует исключение, если клиент не найден
     */
    @Override
    public Person findPersonById(long id) throws UserNotExistException {
        Person person = getBankDao().findPersonWithPassportID(id);
        if (person != null) {
            return person;
        } else {
            throw new UserNotExistException("Пользователь не найден");
        }
    }

    /**
     * Получение персональных данных клиента банка по номеру телефона
     * @param phone - номер телефона клиента
     * @return объект Person, содержащий персональные данные клиента банка
     * @throws UserNotExistException - генерирует исключение, если клиент не найден
     */
    @Override
    public Person findPersonByPhone(long phone) throws UserNotExistException {
        Person person = getBankDao().findPersonByPhone(phone);
        if (person != null) {
            return person;
        } else {
            throw new UserNotExistException("Пользователь с номером  " + phone + " не найден");
        }
    }

    /**
     * Метод, создающий нового пользователя в системе
     * @param customer
     * @param person
     */
    @Override
    public void addNewUser(Customer customer, Person person) {
        getBankDao().createUser(customer, person);
    }
}
