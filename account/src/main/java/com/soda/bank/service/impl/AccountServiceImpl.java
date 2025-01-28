package com.soda.bank.service.impl;

import java.util.List;

import com.soda.bank.entity.Account;
import com.soda.bank.repository.AccountRepository;
import com.soda.bank.service.AccountService;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
	private final AccountRepository AccountRepository;

	@Override
	public Account save(Account Account) {
		return AccountRepository.save(Account);
	}

	@Override
	public List<Account> getAccounts() {
		return AccountRepository.findAll();
	}

	@Override
	public Account getById(Long id) {
		return AccountRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Account not found"));
	}

}
