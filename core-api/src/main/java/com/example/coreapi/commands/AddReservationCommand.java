package com.example.coreapi.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class AddReservationCommand {

    @TargetAggregateIdentifier
    private String idRes;

    private Date dateDebut;
    private Date dateFin;

    private String idCh;
}
