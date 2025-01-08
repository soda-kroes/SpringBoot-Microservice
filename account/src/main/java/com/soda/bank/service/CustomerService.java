package com.soda.bank.service;

import com.soda.bank.exception.AlreadyExistException;
import com.soda.bank.exception.NotFoundException;
import com.soda.bank.request.CustomerRequest;
import com.soda.bank.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer addCustomer (CustomerRequest request) throws AlreadyExistException;
    List<Customer> getAllCustomers ();
    Customer getById(Long id) throws NotFoundException;
    Customer update(Long id, CustomerRequest request) throws NotFoundException;
    Boolean deleteCustomerById(Long id) throws NotFoundException;
}
