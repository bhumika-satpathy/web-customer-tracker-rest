package com.luv2code.springdemo.service;

import com.luv2code.springdemo.dao.CustomerDao;
import com.luv2code.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    // Get the autowired dao
    @Autowired
    CustomerDao customerDao;

    @Override
    @Transactional
    public List<Customer> getCustomers() {

        List<Customer> customers = customerDao.getCustomers();

        return customers;
    }

    @Override
    @Transactional
    public String addCustomer(Customer customer) {

        String res = customerDao.addCustomer(customer);

        return res;

    }

}
