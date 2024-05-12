package com.example.coreapi.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class ReservationAddedEvent {

    private String idRes;

    private Date dateDebut;
    private Date dateFin;

    private String idCh;
}
