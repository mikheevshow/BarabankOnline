//package com.barabank.dao;
//
//import com.barabank.beans.Customer;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@Transactional
//@Repository("barabankDao")
//public class BarabankDao implements Dao {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    public SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    @Transactional(readOnly = true)
//    public List<Customer> findAll() {
//        return sessionFactory.getCurrentSession().createQuery("from Customer c").list();
//    }
//    public List<Customer> findAllWithDetail() {
//        return null;
//    }
//    public Customer findById(long id) {
//        return null;
//    }
//    public Customer save(Customer customer){
//        return null;
//    }
//
//}
