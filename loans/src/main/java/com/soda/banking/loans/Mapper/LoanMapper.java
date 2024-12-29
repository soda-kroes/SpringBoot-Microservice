package com.soda.banking.loans.Mapper;

import com.soda.banking.loans.dto.LoanRequest;
import com.soda.banking.loans.entity.Loan;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class LoanMapper {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Loan toLoan(LoanRequest loanRequest) {
        Loan loan = new Loan();
        loan.setLoanNumber(loanRequest.getLoanNumber());
        loan.setLoanType(loanRequest.getLoanType());
        loan.setAmountPaid(loanRequest.getAmountPaid());
        loan.setTotalLoan(loanRequest.getTotalLoan());
        loan.setCustomerId(loanRequest.getCustomerId());
        loan.setOutstandingAmount(loanRequest.getOutstandingAmount());
        loan.setStartDate(LocalDate.parse(loanRequest.getStartDate(), dateFormatter));
        loan.setCreatedDate(LocalDate.parse(loanRequest.getCreatedDate(), dateFormatter));
        return loan;
    }
}