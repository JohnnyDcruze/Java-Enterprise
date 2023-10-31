package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Train;

@Repository
public interface TrainRepository extends CrudRepository<Train, Integer> {

    // You can define custom query methods here if needed
}

