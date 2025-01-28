package com.soda.bank.service.impl;

import java.util.List;

import com.soda.bank.entity.Customer;
import com.soda.bank.repository.CustomerRepository;
import com.soda.bank.service.CustomerService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
	private final CustomerRepository customerRepository;

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getById(Long id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Customer not found"));
	}

}
