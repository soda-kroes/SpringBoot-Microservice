package com.soda.bank.request;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
public class AccountRequest {

    @NotNull(message = "Customer Id is required!")
    private Long customerId;

    @NotEmpty(message = "Account Type is required!")
    private String accountType;

    @NotEmpty(message = "Branch Address is required!")
    private String branchAddress;
}
