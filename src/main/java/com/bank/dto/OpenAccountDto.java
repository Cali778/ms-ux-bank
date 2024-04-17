package com.bank.dto;

import lombok.Data;

@Data
public class OpenAccountDto {

    private String userId;

    private Long initialBalance;
}
