package com.example.msreservationcommand.repository;

import com.example.msreservationcommand.Aggregate.ReservationAggregate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationAggregate,String> {
}
