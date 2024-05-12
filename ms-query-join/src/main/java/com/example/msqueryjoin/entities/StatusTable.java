package com.example.msqueryjoin.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class StatusTable {

    @Id
    private String idCh;

    @Column(nullable = false)
    private String idH;

    @Column(nullable = false)
    private int nbReservations;
}
