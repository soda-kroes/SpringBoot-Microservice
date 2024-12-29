package com.soda.bank.service.impl;

import com.soda.bank.entity.Account;
import com.soda.bank.entity.Customer;
import com.soda.bank.exception.NotFoundException;
import com.soda.bank.helper.ClsHelper;
import com.soda.bank.repository.AccountRepository;
import com.soda.bank.request.AccountRequest;
import com.soda.bank.service.AccountService;
import com.soda.bank.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final ClsHelper clsHelper;

    @Override
    public Account createAccount(AccountRequest request) throws NotFoundException {
        //CHECK CUSTOMER
        Customer customer = customerService.getById(request.getCustomerId());

        Account account = new Account();
        account.setCustomer(customer);
        account.setBranchAddress(request.getBranchAddress());
        account.setAccountType(request.getAccountType());

        String generateUniqueNumber = clsHelper.generateUniqueNumber();
        account.setAccountNumber("ACC" + generateUniqueNumber);
        account.setCreateDate(LocalDate.now());
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountByAcctNumber(String accountNumber) throws NotFoundException {
         return accountRepository.findByAccountNumber(accountNumber).orElseThrow(()-> new NotFoundException("Account Number = "+accountNumber+" Not Found"));
    }

    @Override
    public Account updateAccount(Long id, AccountRequest request) {
        return null;
    }

    @Override
    public void deleteAccount(Long id) {

    }
}
