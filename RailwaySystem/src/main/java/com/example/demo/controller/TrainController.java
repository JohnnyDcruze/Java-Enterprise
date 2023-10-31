package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Train;
import com.example.demo.repository.TrainRepository;
import com.example.demo.service.TrainService;

@Controller
public class TrainController {
    @Autowired
    TrainService service;
    @Autowired
    private TrainRepository trainRepository;
    
    @GetMapping("/addTrain")
    public String showAddTrainForm() {
        return "addTrain";
    }
 
    @PostMapping("/addTrain")
    public ModelAndView addTrain(
        @RequestParam String train_number,
        @RequestParam String train_name,
        @RequestParam String start_point,
        @RequestParam String end_point,
        @RequestParam String departure_time
    ) {
        // Create a new Train
        Train train = new Train();
        train.setTrain_number(train_number);
        train.setTrain_name(train_name);
        train.setStart_point(start_point);
        train.setEnd_point(end_point);
        train.setDeparture_time(departure_time);
 
        // Save the train to the database
        trainRepository.save(train);
 
        // Fetch all the trains from the database
        Iterable<Train> allTrains = trainRepository.findAll();
 
        // Create a ModelAndView to display a success message and the list of all trains
        ModelAndView modelAndView = new ModelAndView("schedule");
        modelAndView.addObject("train", train);
        modelAndView.addObject("trains", allTrains);
 
        return modelAndView;
    }
    @GetMapping("/train")
    public String listTrains(Model model) {
        Iterable<Train> trains = service.getAllTrains();
        model.addAttribute("trains", trains);
        return "schedule";
    }
}

