package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.TicketBooking;
import com.example.demo.repository.dailyReportRepository;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class DailyReportController {

    @Autowired
    private dailyReportRepository dailyReportRepository;

    @GetMapping("/dailyReport")
    public String showDailyReportForm() {
        return "dailyReport";
    }

    @PostMapping("/dailyReport")
    public String generateDailyReport(@RequestParam("selectedDate") Date selectedDate, Model model) {
        // Fetch records from the database for the selected date
        Iterable<TicketBooking> bookings = dailyReportRepository.findAll();
        // Initialize counters for single and return journeys
        int singleJourneyCount = 0;
        int returnJourneyCount = 0;
        int Total_Count=0;
 
        // Process the records and calculate counts
        for (TicketBooking booking : bookings) {
        	
           if (booking.getTravelDate().equals(selectedDate)){
        	   
            if (booking.getJourney().equals("single")) {
                singleJourneyCount++;
            } else if (booking.getJourney().equals("return")) {
                returnJourneyCount++;
            }
          }
        }
        Total_Count=(int) (singleJourneyCount+(0.5*returnJourneyCount));
 
        // Add the calculated counts to the model
        model.addAttribute("selectedDate", selectedDate);
        model.addAttribute("singleJourneyCount", singleJourneyCount);
        model.addAttribute("returnJourneyCount", returnJourneyCount);
        model.addAttribute("TotalJourneyCount",Total_Count);
 
        return "dailyReport"; // Return the JSP to display the report
    }
    

  
}
