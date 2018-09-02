//package com.barabank.dao;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;
//
//public class MyClass {
//    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
//
//        System.out.println("Контекст создан");
//
//        BarabankDao barabankDao = (BarabankDao) context.getBean("barabankDao");
//
//        System.out.println(barabankDao.findAll().get(0).getPhone());
//    }
//}
