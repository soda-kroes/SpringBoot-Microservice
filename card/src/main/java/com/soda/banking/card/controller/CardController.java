package com.soda.banking.card.controller;

import com.soda.banking.card.dto.CartDTO;
import com.soda.banking.card.entity.Card;
import com.soda.banking.card.mapper.CardMapper;
import com.soda.banking.card.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    private final CardMapper cardMapper;

    @PostMapping()
    public ResponseEntity<?> saveCard(@RequestBody CartDTO cartDTO){
        Card card = cardMapper.toCard(cartDTO);
        Card response = cardService.saveCard(card);
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<?> getAll(){
        List<Card> list = cardService.getList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{customerId}")
    public ResponseEntity<?> getByCustomerId(@PathVariable("customerId") Long customerId){
        List<Card> response = cardService.getByCustomerId(customerId);
        return ResponseEntity.ok(response);
    }
}
