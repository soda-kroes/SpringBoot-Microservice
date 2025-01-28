package com.soda.bank.mapper;

import java.time.LocalDate;

import com.soda.bank.dto.CustomerDTO;
import com.soda.bank.entity.Customer;
import org.springframework.stereotype.Component;



@Component
public class CustomerMapper {

	public Customer toCustomer(CustomerDTO dto) {
		Customer customer = new Customer();
		customer.setName(dto.getName());
		customer.setEmail(dto.getEmail());
		customer.setMobileNumber(dto.getMobileNumber());
		customer.setCreateDate(LocalDate.parse(dto.getCreateDate()));
		return customer;
	}
	
	public CustomerDTO toCustomerDTO(Customer entity) {
		CustomerDTO dto = new CustomerDTO();
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setMobileNumber(entity.getMobileNumber());
		dto.setCreateDate(entity.getCreateDate() != null? entity.getCreateDate().toString() : "");
		return dto;
	}
}
