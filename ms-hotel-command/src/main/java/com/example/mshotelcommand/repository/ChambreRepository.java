package com.example.mshotelcommand.repository;

import com.example.mshotelcommand.Aggregate.ChambreAggregate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<ChambreAggregate, String> {
}
