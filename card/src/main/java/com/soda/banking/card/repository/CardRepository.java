package com.soda.banking.card.repository;

import com.soda.banking.card.entity.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends MongoRepository<Card,Long> {
    List<Card> findByCustomerId(Long customerId);
}
