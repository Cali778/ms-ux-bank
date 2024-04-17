package com.bank.aggregate.cmd;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepositAccountMoneyCmd {

    @TargetAggregateIdentifier
    private String id;

    private Long amount;

}
