package com.soda.banking.card.services.impl;

import com.soda.banking.card.entity.Card;
import com.soda.banking.card.repository.CardRepository;
import com.soda.banking.card.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;

    @Override
    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public List<Card> getList() {
        return cardRepository.findAll();
    }

    @Override
    public List<Card> getByCustomerId(Long customerId) {
        List<Card> customer = cardRepository.findByCustomerId(customerId);
        return customer;
    }


}
