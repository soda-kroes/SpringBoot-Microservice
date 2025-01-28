package com.soda.bank.service;


import com.soda.bank.entity.Customer;

import java.util.List;

public interface CustomerService {
	Customer save(Customer customer);
	
	List<Customer> getCustomers();
	
	Customer getById(Long id);
}
