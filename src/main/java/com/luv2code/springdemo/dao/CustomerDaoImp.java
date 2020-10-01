package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImp implements CustomerDao{

    // Autowire and define a sessionFactory object
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        // Get the session
        Session session = sessionFactory.getCurrentSession();

        // Get the list of customers
        List<Customer> customers = session.createQuery("from Customer").getResultList();

        return customers;
    }

    @Override
    public String addCustomer(Customer customer) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(customer);

        return "Added customer successfully";
    }

}
