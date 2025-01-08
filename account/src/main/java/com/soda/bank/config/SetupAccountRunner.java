package com.soda.bank.config;

import com.soda.bank.entity.Account;
import com.soda.bank.entity.Customer;
import com.soda.bank.repository.AccountRepository;
import com.soda.bank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@Slf4j
public class SetupAccountRunner implements CommandLineRunner {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        Customer customer = new Customer();
        customer.setCreatedDate(LocalDate.now());
        customer.setEmail("soda@gmail.com");
        customer.setMobileNumber("010987001");
        customer.setName("Soda.Kroes");
        customerRepository.save(customer);

        Account account = new Account();
        account.setAccountNumber("001");
        account.setAccountType("Saving");
        account.setBranchAddress("Phnom Penh");
        account.setCreateDate(LocalDate.now());
        account.setCustomer(customer);
        accountRepository.save(account);

        log.info("Account created");
    }
}
