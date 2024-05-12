package com.example.coreapi.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data @AllArgsConstructor @NoArgsConstructor
public class AddHotelCommand {

    @TargetAggregateIdentifier
    private String idH;
    private String nom;
    private Integer nbEtoiles;
}
