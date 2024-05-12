package com.example.coreapi.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data @AllArgsConstructor @NoArgsConstructor
public class ChambreAddedEvent {
    private String idCh;
    private String type;
    private Integer etage;
    private String idH;
}
