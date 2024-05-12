package com.example.mshotelcommand.Aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.EntityId;

import jakarta.persistence.*;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class ChambreAggregate {

    @Id
    @EntityId
    private String idCh;

    private String type;

    private int etage;

    @ManyToOne
    private HotelAggregate hotel;
}
