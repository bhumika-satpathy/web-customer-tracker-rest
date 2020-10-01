package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    // Autowire the customerService
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){

        // Get the customers
        List<Customer>customers = customerService.getCustomers();

        return customers;
    }

    @PostMapping("/customers")
    public String addCustomer(@RequestBody Customer customer){

        // Set the customer id to 0 so as to save the customer and not update the customer
        customer.setId(0);

        // Add a customer
        String res = customerService.addCustomer(customer);

        return res;
    }

    @PutMapping("/customers")
    public Customer getCustomerById(@RequestBody Customer customer){

        // Get the customer by id
        customerService.addCustomer(customer);

        // return the customer
        return customer;
    }

}
