package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.FromLocation;
import com.example.demo.repository.FromLocationRepository;

@Service
public class FromLocationService {
    @Autowired
    FromLocationRepository FromLocationRepository;

    public Iterable<FromLocation> getAllTrains() {
    	Iterable<FromLocation> fromTrains=FromLocationRepository.findAll();
		return fromTrains;
    }
}