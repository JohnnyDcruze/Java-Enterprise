package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entities.ToLocation;
import com.example.demo.service.ToLocationService;

@Controller
public class ToLocationController {
    @Autowired
    ToLocationService service;

    @GetMapping("/ToLocation")
    public Iterable<ToLocation> listTrains(Model model) {
        Iterable<ToLocation> ToLocation = service.getAllTrains();
//        model.addAttribute("fromTrains", fromLocation);
        return ToLocation;
    }
}