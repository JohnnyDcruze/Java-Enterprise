package com.example.demo.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.FromLocation;
import com.example.demo.entities.ToLocation;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FromLocationService;
import com.example.demo.service.ToLocationService;

import jakarta.servlet.http.HttpSession;
 
@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    FromLocationService service;
    @Autowired 
    ToLocationService toservice;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    @GetMapping("/dashboard")
    public ModelAndView dashboardPage(Model model) {
        Iterable<FromLocation> fromLocation = service.getAllTrains(); // Replace with your method for "from" trains
        Iterable<ToLocation> toLocation = toservice.getAllTrains(); // Replace with your method for "to" trains

        ModelAndView mv = new ModelAndView();
        mv.addObject("fromTrains", fromLocation);
        mv.addObject("toTrains", toLocation);
        mv.setViewName("dashboard");

        return mv;
    }

//    @GetMapping("/dashboard")
//    public ModelAndView dashboardPage(Model model) {
//    	Iterable<FromLocation> fromLocation = service.getAllTrains();
//    	ModelAndView mv = new ModelAndView();
//    	mv.addObject("fromTrains", fromLocation);
//    	mv.setViewName("dashboard");
////    	model.addAttribute("fromTrains",fromLocation);
//    	return mv;
//    }

    @PostMapping("/login")
    public String login(@RequestParam String user, @RequestParam String pass, HttpSession session) {
        User userFromDB = userRepository.findByUsernameAndPassword(user, pass);
        if (userFromDB != null) {
            // Authentication successful
            session.setAttribute("loggedInUser", userFromDB);
            return "redirect:/dashboard"; // Redirect to a dashboard page
        } else {
            // Authentication failed
            return "redirect:/error"; // Return to the login page with an error message
        }
    }
}
