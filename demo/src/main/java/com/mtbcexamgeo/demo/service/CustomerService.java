package com.mtbcexamgeo.demo.service;

import com.mtbcexamgeo.demo.model.Customer;
import com.mtbcexamgeo.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long customerNumber) {
        return customerRepository.findById(customerNumber).orElse(null);
    }
}
