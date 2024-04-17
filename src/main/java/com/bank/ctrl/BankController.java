package com.bank.ctrl;

import com.bank.dto.DepositAccountMoneyDto;
import com.bank.dto.OpenAccountDto;
import com.bank.dto.WithdrawAccountMoneyDto;
import com.bank.service.BankService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bank")
public class BankController {

    private final BankService bankService;

    @PostMapping("/openAccount")
    public CompletableFuture<Object> openAccount(@RequestBody OpenAccountDto dto) {
        return bankService.openAccount(dto);
    }

    @PostMapping("/depositAccount")
    public void depositAccount(@RequestBody DepositAccountMoneyDto dto) {
        bankService.depositAccount(dto);
    }

    @PostMapping("/withdrawAccount")
    public void withdrawAccount(@RequestBody WithdrawAccountMoneyDto dto) {
        bankService.withdrawAccount(dto);
    }
}
