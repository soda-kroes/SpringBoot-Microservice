package com.soda.bank.service;

import com.soda.bank.entity.Account;
import com.soda.bank.exception.NotFoundException;
import com.soda.bank.request.AccountRequest;

import java.util.List;

public interface AccountService {
    Account createAccount(AccountRequest request) throws NotFoundException;

    List<Account> getAllAccounts();

    Account getAccountByAcctNumber(String accountNumber) throws NotFoundException;

    Account updateAccount(Long id, AccountRequest request);

    void deleteAccount(Long id);
}
