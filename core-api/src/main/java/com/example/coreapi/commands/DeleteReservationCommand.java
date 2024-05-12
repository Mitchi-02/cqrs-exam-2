package com.example.coreapi.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class DeleteReservationCommand {

    @TargetAggregateIdentifier
    private String idRes;
}
