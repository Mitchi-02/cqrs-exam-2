package com.example.msqueryjoin.repository;

import com.example.msqueryjoin.entities.StatusTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusTableRepository extends JpaRepository<StatusTable, String> {
}