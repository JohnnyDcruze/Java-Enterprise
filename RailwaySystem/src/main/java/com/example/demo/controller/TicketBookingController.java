package com.example.demo.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.FromLocation;
import com.example.demo.entities.TicketBooking;
import com.example.demo.entities.ToLocation;
import com.example.demo.entities.TrainRoute;
import com.example.demo.repository.TicketBookingRepository;
import com.example.demo.repository.FromLocationRepository;
import com.example.demo.repository.ToLocationRepository;
import com.example.demo.repository.TrainRouteRepository;

@Controller
public class TicketBookingController {
    @Autowired
    private TicketBookingRepository bookingRepository;

    @Autowired
    private FromLocationRepository fromLocationRepository;
    
    @Autowired
    private TrainRouteRepository trainRouteRepository;

    @Autowired
    private ToLocationRepository toLocationRepository;

    @GetMapping("/ticketBooking")
    public String showTicketBookingForm(Model model) {
        // Retrieve data from the database for the "From" and "To" dropdowns
        List<FromLocation> fromLocations = fromLocationRepository.findAll();
        List<ToLocation> toLocations = toLocationRepository.findAll();

        model.addAttribute("from_locations", fromLocations);
        model.addAttribute("to_location", toLocations);

        return "ticketBookingForm";
    }



    @PostMapping("/ticketBooking")
    public ModelAndView submitTicketBooking(
        @RequestParam String fromLocation,
        @RequestParam String toLocation,
        @RequestParam Date date,
        @RequestParam String travelClass,
        @RequestParam String Journey,
        Model model
    ) {
        // Create a new ticket booking
        TicketBooking booking = new TicketBooking();
        booking.setFromLocation(fromLocation);
        booking.setToLocation(toLocation);
        booking.setTravelDate(date);
        booking.setTravelClass(travelClass);
        booking.setJourney(Journey);
     
        TrainRoute trainRoute = trainRouteRepository.findByFromLocationAndToLocation(fromLocation, toLocation);
     
        double ticketPrice = calculateTicketPrice(trainRoute, travelClass, Journey);
     
        booking.setTicketPrice(ticketPrice);
     
        bookingRepository.save(booking);
     
        ModelAndView modelAndView = new ModelAndView("ticket");
        modelAndView.addObject("ticketBooking", booking);
     
        return modelAndView;
    }
     
    private double calculateTicketPrice(TrainRoute trainRoute, String travelClass, String journey) {
     
        double basePrice = trainRoute.getKm() * 0.1; 
        double classPrice = travelClass.equals("Business") ? 50.0 : 30.0; 
        double journeyPrice = journey.equals("return") ? 2.0 : 1.0;
     
        return basePrice * classPrice * journeyPrice;
    }
	
}
