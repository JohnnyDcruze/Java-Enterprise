package com.example.demo.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.TicketBooking;
import com.example.demo.repository.TicketBookingRepository;

@Controller
public class MonthlyReportController {

    @Autowired
    private TicketBookingRepository ticketBookingRepository;

    @GetMapping("/monthlyReport")
    public String showMonthlyReportForm() {
        return "monthlyReport";
    }

    @PostMapping("/monthlyReport")
    public String generateMonthlyReport(@RequestParam("selectedMonth") String selectedMonth,
    		@RequestParam("selectedYear") String selectedYear,Model model) {
    

        Iterable<TicketBooking> allBookings = ticketBookingRepository.findAll();

        int singleJourneyCount = 0;
        int returnJourneyCount = 0;

        for (TicketBooking booking : allBookings) {
        	 int bookingMonth = booking.getTravelDate().toLocalDate().getMonthValue();
        	 int bookingYear=booking.getTravelDate().toLocalDate().getYear();
        	System.out.println(bookingMonth);
            if (bookingMonth == Integer.parseInt(selectedMonth)&&bookingYear==Integer.parseInt(selectedYear)) {
                if ("single".equals(booking.getJourney())) {
                    singleJourneyCount++;
                } else if ("return".equals(booking.getJourney())) {
                    returnJourneyCount++;
                }
            }
        }

        int totalJourneyCount = singleJourneyCount + (int) (returnJourneyCount * 0.5);

        model.addAttribute("selectedMonth", selectedMonth);
        model.addAttribute("singleJourneyCount", singleJourneyCount);
        model.addAttribute("returnJourneyCount", returnJourneyCount);
        model.addAttribute("totalJourneyCount", totalJourneyCount);

        return "monthlyReport";
    }

	
}
