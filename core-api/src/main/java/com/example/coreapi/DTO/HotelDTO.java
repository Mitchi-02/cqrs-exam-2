package com.example.coreapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor

public class HotelDTO {
    private String idH;
    private String nom;
    private Integer nbEtoiles;
}
