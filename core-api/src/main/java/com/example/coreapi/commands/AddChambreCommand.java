package com.example.coreapi.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data @AllArgsConstructor @NoArgsConstructor
public class AddChambreCommand {

    private String idCh;
    private String type;
    private Integer etage;

    @TargetAggregateIdentifier
    private String idH;
}
