package com.soda.bank.service.client;

import java.util.List;

import com.soda.bank.dto.LoanResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "loan", url = "localhost:8090")
public interface LoanFeignClient {
    @GetMapping("/api/loans/{customerId}")
    List<LoanResponseDTO> getLoanInfo(@PathVariable Long customerId);
}
