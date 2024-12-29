package com.soda.banking.card.repository;

import com.soda.banking.card.entity.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardRepository extends MongoRepository<Card,Long> {
}
