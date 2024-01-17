package com.example.endeavaor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.endeavaor.entity.CarsDetails;

public interface CarsDetailsRepository extends JpaRepository<CarsDetails, Integer> {
    // You can add custom query methods if needed
}
