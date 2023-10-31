package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.ToLocation;

public interface ToLocationRepository extends JpaRepository<ToLocation, Long> {
}
