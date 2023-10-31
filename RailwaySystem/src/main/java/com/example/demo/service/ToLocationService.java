package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ToLocation;
import com.example.demo.repository.ToLocationRepository;

@Service
public class ToLocationService {
    @Autowired
    ToLocationRepository ToLocationRepository;

    public Iterable<ToLocation> getAllTrains() {
    	Iterable<ToLocation> ToTrains=ToLocationRepository.findAll();
		return ToTrains;
    }
}