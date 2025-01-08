package com.soda.banking.loans.repository;

import com.soda.banking.loans.entity.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends MongoRepository<Loan,Long> {
    List<Loan> findByCustomerId(Long customerId);
}
