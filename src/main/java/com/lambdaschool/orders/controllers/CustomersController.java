package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {
    @Autowired
    CustomerService customerService;

    // http://localhost:2019/customers/orders
    @GetMapping(value = "/orders")
    public ResponseEntity<?> getAllCustomers() {
        List<Customer> customers = customerService.findAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // http://localhost:2019/customers/customer/{id}
    @GetMapping(value = "/customer/{id}")
    public ResponseEntity<?> getCustomerWithId(@PathVariable String id) {
        Customer customer = customerService.findCustomerById(Long.parseLong(id));
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    // http://localhost:2019/customers/namelike/{likename}
    // http://localhost:2019/customers/orders/count
}
