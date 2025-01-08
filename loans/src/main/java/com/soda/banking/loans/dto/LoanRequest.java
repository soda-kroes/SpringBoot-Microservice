package com.soda.banking.loans.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanRequest {
    private Long loanNumber;
    private Long customerId;
    private String startDate;
    private String loanType;
    private Long totalLoan;
    private Long amountPaid;
    private Long outstandingAmount;
    private String createdDate;
}
