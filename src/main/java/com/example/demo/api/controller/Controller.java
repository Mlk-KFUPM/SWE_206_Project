package com.example.demo.api.controller;

import com.example.demo.api.model.Facility;
import com.example.demo.api.model.Reservation;
import com.example.demo.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

class LoginRequest {
    public String email;
    public String password;
}
@RestController
public class Controller {

    private final Services services;

    @Autowired
    public Controller(Services services){
        this.services = services;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequest body){
        return  services.login(body.email, body.password);
    }
    @GetMapping("/facilities")
    public Object getFacilities(@RequestParam String userID){
        return services.facilities(userID);
    }

    @GetMapping("/reservation")
    public boolean reservation(@RequestParam String facilityName, @RequestParam String gender, @RequestParam String timing, @RequestParam String userID){
        return  services.addReservation(facilityName, gender, timing, userID);
    }
    @GetMapping("/userReservations")
    public Object userReservations(@RequestParam String userID){
        return  services.userReservations(userID);
    }
}