package com.example.coreapi.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class HotelAddedEvent {
    private String idH;
    private String nom;
    private Integer nbEtoiles;
}
