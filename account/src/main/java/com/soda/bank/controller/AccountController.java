package com.soda.bank.controller;

import com.soda.bank.dto.AccountDTO;
import com.soda.bank.entity.Account;
import com.soda.bank.mapper.AccountMapper;
import com.soda.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountMapper accountMapper;

    @PostMapping
    public ResponseEntity<?> saveAccount(@RequestBody AccountDTO dto) {
        Account Account = accountMapper.toAccount(dto);
        Account = accountService.save(Account);
        return ResponseEntity.ok(Account);
    }

    @GetMapping
    public ResponseEntity<?> getAccounts() {
        return ResponseEntity.ok(accountService.getAccounts());
    }

    @GetMapping("{accountId}")
    public ResponseEntity<?> getAccounts(@PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.getById(accountId));
    }

}
