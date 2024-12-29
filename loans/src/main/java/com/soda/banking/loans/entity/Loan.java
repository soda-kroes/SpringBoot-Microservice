package com.soda.banking.loans.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;

@Data
@Document(collection = "loan")
public class Loan {
    private Long loanNumber;
    private Long customerId;
    private LocalDate startDate;
    private String loanType;
    private Long totalLoan;
    private Long amountPaid;
    private Long outstandingAmount;
    private LocalDate createdDate;
}
