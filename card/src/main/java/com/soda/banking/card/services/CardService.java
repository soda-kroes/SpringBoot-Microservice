package com.soda.banking.card.services;

import com.soda.banking.card.entity.Card;

import java.util.List;

public interface CardService {
    Card saveCard(Card card);

    List<Card> getList();
    List<Card> getByCustomerId(Long customerId);
}
