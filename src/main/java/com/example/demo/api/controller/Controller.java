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

class addReservationBody {
    public String facilityName;
    public String timing;
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

    @PostMapping("/reservation")
    public boolean reservation(@RequestBody addReservationBody body, @RequestParam String userID){
        return  services.addReservation(body.facilityName, body.timing, userID);
    }
    @GetMapping("/userReservations")
    public Object userReservations(@RequestParam String userID){
        return  services.userReservations(userID);
    }
}