package com.soda.bank.service.impl;

import com.soda.bank.entity.Customer;
import com.soda.bank.exception.AlreadyExistException;
import com.soda.bank.exception.NotFoundException;
import com.soda.bank.repository.CustomerRepository;
import com.soda.bank.request.CustomerRequest;
import com.soda.bank.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(CustomerRequest request) throws AlreadyExistException {
        // CHECK CUSTOMER BEFORE CREATE NEW
        if (customerRepository.existsByEmail(request.getEmail())) {
            throw new AlreadyExistException("Email already exists!");
        }

        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setMobileNumber(request.getMobileNumber());
        customer.setCreatedDate(LocalDate.now());
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(Long id) throws NotFoundException {
        return customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer with Id = " + id + " not found."));
    }

    @Override
    public Customer update(Long id, CustomerRequest request) throws NotFoundException {
        Customer customerToUpdate = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer with Id = " + id + " not found."));

        customerToUpdate.setName(request.getName());
        customerToUpdate.setEmail(request.getEmail());
        customerToUpdate.setMobileNumber(request.getMobileNumber());

        return customerRepository.save(customerToUpdate);
    }

    @Override
    public Boolean deleteCustomerById(Long id) throws NotFoundException {
        if (!customerRepository.existsById(id)) {
            throw new NotFoundException("Customer with Id = " + id + " not found.");
        }
        customerRepository.deleteById(id);
        return true;
    }
}