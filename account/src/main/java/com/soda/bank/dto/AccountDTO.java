package com.soda.bank.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AccountDTO {
	private Long accountNumber;
	private Long customerId;
	private String accountType;
	private String branchAddress;
	private LocalDate createDate;
}
