package com.bank.service.Impl;

import com.bank.aggregate.cmd.DepositAccountMoneyCmd;
import com.bank.aggregate.cmd.OpenAccountCmd;
import com.bank.aggregate.cmd.WithdrawAccountMoneyCmd;
import com.bank.dto.DepositAccountMoneyDto;
import com.bank.dto.OpenAccountDto;
import com.bank.dto.WithdrawAccountMoneyDto;
import com.bank.service.BankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankServiceImpl implements BankService {

    private final CommandGateway commandGateway;

    @Override
    public CompletableFuture<Object> openAccount(OpenAccountDto dto) {
        String id = UUID.randomUUID().toString();
        OpenAccountCmd cmd = OpenAccountCmd.builder()
                .id(id)
                .userId(dto.getUserId())
                .initialBalance(dto.getInitialBalance())
                .build();
        return commandGateway.send(cmd);
    }

    @Override
    public void depositAccount(DepositAccountMoneyDto dto) {
        DepositAccountMoneyCmd cmd = DepositAccountMoneyCmd.builder()
                .id(dto.getId())
                .amount(dto.getAmount())
                .build();
        commandGateway.send(cmd);
    }

    @Override
    public void withdrawAccount(WithdrawAccountMoneyDto dto) {
        WithdrawAccountMoneyCmd cmd = WithdrawAccountMoneyCmd.builder()
                .id(dto.getId())
                .amount(dto.getAmount())
                .build();
        commandGateway.send(cmd);
    }
}
