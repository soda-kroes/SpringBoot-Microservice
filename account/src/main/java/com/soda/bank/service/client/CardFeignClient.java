package com.soda.bank.service.client;

import java.util.List;

import com.soda.bank.dto.CardResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "card", url = "localhost:8070")
public interface CardFeignClient {
	@GetMapping("/api/cards/{customerId}")
	List<CardResponseDTO> getCardInfo(@PathVariable Long customerId);

}
