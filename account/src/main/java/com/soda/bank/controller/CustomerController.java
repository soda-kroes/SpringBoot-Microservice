package com.soda.bank.controller;

import com.soda.bank.entity.Customer;
import com.soda.bank.exception.AlreadyExistException;
import com.soda.bank.exception.NotFoundException;
import com.soda.bank.request.CustomerRequest;
import com.soda.bank.response.StatusResponse;
import com.soda.bank.service.CustomerService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping()
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody CustomerRequest request) throws AlreadyExistException {
        Customer customer = customerService.addCustomer(request);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable long id) throws NotFoundException {
        Customer customer = customerService.getById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@Valid @PathVariable Long id, @RequestBody CustomerRequest request) throws NotFoundException {
        Customer customer = customerService.update(id, request);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<StatusResponse> deleteCustomer(@PathVariable Long id) throws NotFoundException {
        Boolean deleted = customerService.deleteCustomerById(id);
        StatusResponse res = new StatusResponse();
        if (deleted) {
            res.setCode(200);
            res.setMessage("Customer deleted from system successfully");
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}