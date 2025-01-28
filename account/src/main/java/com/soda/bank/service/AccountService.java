package com.soda.bank.service;

import com.soda.bank.entity.Account;

import java.util.List;



public interface AccountService {
	Account save(Account Account);
	List<Account> getAccounts();
	Account getById(Long id);
}
