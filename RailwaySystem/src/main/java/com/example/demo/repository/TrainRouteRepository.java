package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.TrainRoute;

import java.util.List;
 
public interface TrainRouteRepository extends JpaRepository<TrainRoute, Long> {
    TrainRoute findByFromLocationAndToLocation(String fromLocation, String toLocation);
    // Add other custom methods if needed
}