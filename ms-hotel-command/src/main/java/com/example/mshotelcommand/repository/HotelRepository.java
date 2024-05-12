package com.example.mshotelcommand.repository;

import com.example.mshotelcommand.Aggregate.HotelAggregate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<HotelAggregate,String> {
}
