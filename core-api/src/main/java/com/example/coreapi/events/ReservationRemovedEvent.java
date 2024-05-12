package com.example.coreapi.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class ReservationRemovedEvent {

    private String idRes;
    private String idCh;
}
