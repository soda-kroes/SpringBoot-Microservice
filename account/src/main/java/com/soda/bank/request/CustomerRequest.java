package com.soda.bank.request;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CustomerRequest {
    @NotEmpty(message = "Name is required!")
    private String name;

    @NotEmpty(message = "Email is required!")
    private String email;

    @NotEmpty(message = "Mobile Number is required!")
    private String mobileNumber;

    private String createdDate;
}
