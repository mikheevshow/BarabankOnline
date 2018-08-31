package com.barabank.dao;


import com.barabank.beans.*;

import javax.annotation.Resource;
import java.util.List;


public interface Dao {

    public List<Customer> findAll();
    public List<Customer> findAllWithDetail();
    public Customer findById(long id);
    public Customer save(Customer customer);

}
