package com.soda.bank.response;

import lombok.Data;

import java.util.Map;

@Data
public class MandatoryResponse {
    private Integer code;
    private String message;
    private Map<String, String> errors;
}
