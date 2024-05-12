package com.example.coreapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor

public class ReservationDTO {
    private String idRes;
    private Date dateDebut;
    private Date dateFin;
    private String idCh;
}
