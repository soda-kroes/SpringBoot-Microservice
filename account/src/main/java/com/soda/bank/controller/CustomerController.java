package com.soda.bank.controller;

import com.soda.bank.dto.CardResponseDTO;
import com.soda.bank.dto.CustomerDTO;
import com.soda.bank.dto.CustomerDetailDTO;
import com.soda.bank.dto.LoanResponseDTO;
import com.soda.bank.entity.Customer;
import com.soda.bank.mapper.CustomerMapper;
import com.soda.bank.service.CustomerService;
import com.soda.bank.service.client.CardFeignClient;
import com.soda.bank.service.client.LoanFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CardFeignClient cardFeignClient;

    @Autowired
    private LoanFeignClient loanFeignClient;

    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDTO dto) {
        Customer customer = customerMapper.toCustomer(dto);
        customer = customerService.save(customer);
        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity<?> getCustomers() {
        return ResponseEntity.ok(customerService.getCustomers());
    }

    @GetMapping("{customerId}")
    public ResponseEntity<?> getCustomers(@PathVariable Long customerId) {
        return ResponseEntity.ok(customerService.getById(customerId));
    }

    @GetMapping("customerDetail/{myCustomerId}")
    public ResponseEntity<CustomerDetailDTO> getCustomerDetail(@PathVariable("myCustomerId") Long customerId) {
        CustomerDetailDTO dto = new CustomerDetailDTO();
        Customer customer = customerService.getById(customerId);
        if (customer == null) {
            throw new RuntimeException("No customer found with this id");
        }
        CustomerDTO customerDTO = customerMapper.toCustomerDTO(customer);

        List<LoanResponseDTO> loanInfo = loanFeignClient.getLoanInfo(customerId);
        List<CardResponseDTO> cardInfo = cardFeignClient.getCardInfo(customerId);

        dto.setCustomer(customerDTO);
        dto.setLoans(loanInfo);
        dto.setCards(cardInfo);


        return ResponseEntity.ok(dto);
    }


}
