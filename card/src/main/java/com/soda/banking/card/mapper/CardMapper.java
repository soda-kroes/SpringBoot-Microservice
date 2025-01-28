package com.soda.banking.card.mapper;

import com.soda.banking.card.dto.CartDTO;
import com.soda.banking.card.entity.Card;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CardMapper {
    public Card toCard (CartDTO cartDTO){
        Card card = new Card();
        card.setCardNumber(cartDTO.getCardNumber());
        card.setCardId(cartDTO.getCardId());
        card.setAmountUsed(cartDTO.getAmountUsed());
        card.setCartType(cartDTO.getCartType());
        card.setTotalLimit(cartDTO.getTotalLimit());
        card.setAvailableAmount(cartDTO.getAvailableAmount());
        card.setCreatedDate(LocalDate.parse(cartDTO.getCreatedDate()));
        card.setCustomerId(cartDTO.getCustomerId());
        return card;
    }
}
