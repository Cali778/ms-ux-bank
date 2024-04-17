package com.bank.aggregate.cmd;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenAccountCmd {

    @TargetAggregateIdentifier
    private String id;

    private String userId;

    private Long initialBalance;
}
