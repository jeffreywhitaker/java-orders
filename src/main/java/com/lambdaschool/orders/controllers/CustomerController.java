package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    // GET http://localhost:2019/customer/order
    @GetMapping(value = "/order", produces = {"application/json"})
    public ResponseEntity<?> getAllCustomersAndTheirOrders()
    {
        List<Customer> custList = customerService.findall();
        return new ResponseEntity<>(custList, HttpStatus.OK);
    }

    // GET http://localhost:2019/customer/{custcode} NOTE THIS IS NOT PART OF MVP

    // POST http://localhost:2019/customer/new
    @PostMapping(value = "/new", consumes = {"application/json"})
    public ResponseEntity<?> postNewCustomer(@Valid @RequestBody Customer newCustomer)
    {
        customerService.save(newCustomer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // PUT http://localhost:2019/customer/update/{custcode}
    @PutMapping(value = "/update/{custcode}", consumes = {"application/json"})
    public ResponseEntity<?> updateCustomerById(@RequestBody Customer customer, @PathVariable long custcode)
    {
        customerService.update(customer, custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DEL http://localhost:2019/customer/delete/{custcode}
    @DeleteMapping("/delete/{custcode}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable long custcode)
    {
        customerService.delete(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
