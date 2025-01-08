package com.soda.banking.loans.services.impl;

import com.soda.banking.loans.entity.Loan;
import com.soda.banking.loans.repository.LoanRepository;
import com.soda.banking.loans.services.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;

    @Override
    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> getList() {
        return loanRepository.findAll();
    }

    @Override
    public List<Loan> getByCustomerId(Long customerId) {
        return loanRepository.findByCustomerId(customerId);
    }
}