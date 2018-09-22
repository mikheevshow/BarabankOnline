package com.barabank.service.logic;

import com.barabank.beans.Customer;
import com.barabank.beans.Person;
import com.barabank.dao.BankDao;
import com.barabank.service.exceptions.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

/**
 * @author Ilya Mikheev
 * @author Leonid Zemenkov
 */

@Service
public class BarabankUserService implements BankUserService {

    private BankDao bankDao;

    @Autowired
    public BarabankUserService(BankDao bankDao) {
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
        try {
            Customer customer = bankDao.findCustomerByPhone(phone);
            return customer;
        } catch (NoResultException ex){
            throw new UserNotExistException("cant find customer by phone: "+phone,ex);
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
        try {
            Person person = bankDao.findPersonWithPassportID(id);
            return person;
        } catch (NoResultException ex){
            throw new UserNotExistException("cant find person by id: "+id,ex);
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
        try {
            Person person = bankDao.findPersonByPhone(phone);
            return person;
        } catch (NoResultException ex){
            throw new UserNotExistException("cant find person by phone: "+phone,ex);
        }
    }

    /**
     * Метод, создающий нового пользователя в системе
     * @param customer
     */
    @Override
    public void addNewUser(Customer customer) {
        bankDao.saveCustomer(customer);
    }
}
