package com.example.demo.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.entities.TicketBooking;
import com.example.demo.repository.TicketBookingRepository;

@Controller
public class TicketBookingController {
    @Autowired
    private TicketBookingRepository bookingRepository;

    @GetMapping("/ticketBooking")
    public String showTicketBookingForm() {
        return "ticketBookingForm";
    }

    @PostMapping("/ticketBooking")
    public ModelAndView submitTicketBooking(
        @RequestParam String fromLocation,
        @RequestParam String toLocation,
        @RequestParam Date date,
        @RequestParam String travelClass
    ) {
        // Create a new ticket booking
        TicketBooking booking = new TicketBooking();
        booking.setFromLocation(fromLocation);
        booking.setToLocation(toLocation);
        booking.setTravelDate(date);
        booking.setTravelClass(travelClass);

        // Save the booking to the database
        bookingRepository.save(booking);

        // Create a ModelAndView to display the ticket
        ModelAndView modelAndView = new ModelAndView("ticket");
        modelAndView.addObject("ticketBooking", booking);

        return modelAndView;
    }
}
