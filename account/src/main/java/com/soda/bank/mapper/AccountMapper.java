package com.soda.bank.mapper;

import com.soda.bank.dto.AccountDTO;
import com.soda.bank.entity.Account;
import org.springframework.stereotype.Component;


@Component
public class AccountMapper {

	public Account toAccount(AccountDTO dto) {
		Account account = new Account();
		account.setAccountNumber(dto.getAccountNumber());
		account.setAccountType(dto.getAccountType());
		account.setBranchAddress(dto.getBranchAddress());
		account.setCreateDate(dto.getCreateDate());
		//account.setCustomerId(dto.getCustomerId());
		return account;
	}
}
