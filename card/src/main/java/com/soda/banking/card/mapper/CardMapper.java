package com.soda.banking.card.mapper;

import com.soda.banking.card.dto.CardRequest;
import com.soda.banking.card.entity.Card;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CardMapper {
    public Card toCard (CardRequest cardRequest){
        Card card = new Card();
        card.setCardNumber(cardRequest.getCardNumber());
        card.setCardId(cardRequest.getCardId());
        card.setAmountUsed(cardRequest.getAmountUsed());
        card.setCartType(cardRequest.getCartType());
        card.setTotalLimit(cardRequest.getTotalLimit());
        card.setAvailableAmount(cardRequest.getAvailableAmount());
        card.setCreatedDate(LocalDate.parse(cardRequest.getCreatedDate()));
        card.setCustomerId(cardRequest.getCustomerId());
        return card;
    }
}
