package com.soda.banking.loans.repository;

import com.soda.banking.loans.entity.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends MongoRepository<Loan,Long> {
}
