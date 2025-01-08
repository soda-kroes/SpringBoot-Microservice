package com.soda.banking.loans.services;

import com.soda.banking.loans.entity.Loan;

import java.util.List;

public interface LoanService {
    Loan saveLoan (Loan loan);
    List<Loan> getList();
    List<Loan> getByCustomerId (Long customerId);
}
