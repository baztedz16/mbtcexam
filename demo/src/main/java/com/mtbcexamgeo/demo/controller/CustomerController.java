package com.mtbcexamgeo.demo.controller;


import com.mtbcexamgeo.demo.model.Customer;
import com.mtbcexamgeo.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mtbcexamgeo.demo.dto.ErrorResponse;
import com.mtbcexamgeo.demo.dto.SuccessResponse;

@RestController
@RequestMapping("/api/v1/account")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        if (customer.getCustomerEmail() == null || customer.getCustomerEmail().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ErrorResponse(400, "Email is a required field"));
        }

        Customer createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                     new SuccessResponse(createdCustomer.getCustomerNumber(), 201, "Customer account created"));
    }

    @GetMapping("/{customerNumber}")
    public ResponseEntity<?> getCustomer(@PathVariable Long customerNumber) {
        Customer customer = customerService.getCustomerById(customerNumber);

        if (customer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ErrorResponse(401, "Customer not found"));
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(customer);
    }
}


