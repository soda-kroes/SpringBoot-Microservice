package com.soda.banking.loans.controller;

import com.soda.banking.loans.Mapper.LoanMapper;
import com.soda.banking.loans.dto.LoanRequest;
import com.soda.banking.loans.entity.Loan;
import com.soda.banking.loans.services.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;
    private final LoanMapper loanMapper;

    @PostMapping()
    public ResponseEntity<?> saveLoan(@RequestBody LoanRequest loanRequest){
        Loan loan = loanMapper.toLoan(loanRequest);
        Loan response = loanService.saveLoan(loan);
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<?> getAll(){
        List<Loan> response = loanService.getList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("{customerId}")
    public ResponseEntity<?> getByCustomerId(@PathVariable Long customerId){
        List<Loan> response = loanService.getByCustomerId(customerId);
        return ResponseEntity.ok(response);
    }
}
