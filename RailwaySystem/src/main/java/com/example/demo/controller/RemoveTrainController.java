package com.example.demo.controller;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
import com.example.demo.entities.Train;
import com.example.demo.repository.TrainRepository;
 
@Controller
public class RemoveTrainController {
	@Autowired
    TrainRepository trainRepository;
 
	  
	@GetMapping("/removeTrain")
	public ModelAndView removeTrain() {
	    Iterable<Train> Trains = trainRepository.findAll();
	    Trains.forEach(System.out::println);
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("trains", Trains);
	    modelAndView.setViewName("removeTrain");
	    return modelAndView;
	}
	@PostMapping("/removeTrain")
    public ModelAndView removeTrain(@RequestParam Integer selectedTrain) {
        // Use the selectedTrain ID to remove the train from the database
        // Implement your removal logic here
        // trainRepository.deleteById(selectedTrain);
    	trainRepository.deleteById(selectedTrain);
 
        // Fetch the updated list of trains
        Iterable<Train> updatedTrains = trainRepository.findAll();
 
        ModelAndView modelAndView = new ModelAndView("removeTrain");
        modelAndView.addObject("trains", updatedTrains);
 
        return modelAndView;
    }
}