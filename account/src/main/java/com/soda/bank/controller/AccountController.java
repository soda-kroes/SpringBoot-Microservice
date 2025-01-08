package com.soda.bank.controller;

import com.soda.bank.entity.Account;
import com.soda.bank.exception.NotFoundException;
import com.soda.bank.request.AccountRequest;
import com.soda.bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping()
    public ResponseEntity<?> addAccount(@Valid @RequestBody AccountRequest request) throws NotFoundException {
        Account account = accountService.createAccount(request);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAllAccounts() {
        List<Account> allAccounts = accountService.getAllAccounts();
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }

    @GetMapping("{accountNumber}")
    public ResponseEntity<?> getAccount(@PathVariable(name = "accountNumber") String accountNumber) throws NotFoundException {
        Account account = accountService.getAccountByAcctNumber(accountNumber);
        return new ResponseEntity<>(account,HttpStatus.OK);
    }
}
