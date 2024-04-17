package com.bank.service;

import com.bank.dto.DepositAccountMoneyDto;
import com.bank.dto.OpenAccountDto;
import com.bank.dto.WithdrawAccountMoneyDto;

import java.util.concurrent.CompletableFuture;

public interface BankService {

    public CompletableFuture<Object> openAccount(OpenAccountDto dto);

    public void depositAccount(DepositAccountMoneyDto dto);

    public void withdrawAccount(WithdrawAccountMoneyDto dto);
}
