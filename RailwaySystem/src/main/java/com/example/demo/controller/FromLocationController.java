package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entities.FromLocation;
import com.example.demo.service.FromLocationService;

@Controller
public class FromLocationController {
    @Autowired
    FromLocationService service;

    @GetMapping("/fromLocation")
    public Iterable<FromLocation> listTrains(Model model) {
        Iterable<FromLocation> fromLocation = service.getAllTrains();
//        model.addAttribute("fromTrains", fromLocation);
        return fromLocation;
    }
}