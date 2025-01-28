package com.soda.banking.card.dto;

import lombok.Data;

@Data
public class CartDTO {
    private Long cardId;
    private Long customerId;
    private Long cardNumber;
    private String cartType;
    private Long totalLimit;
    private Long amountUsed;
    private Long availableAmount;
    private String createdDate;
}
