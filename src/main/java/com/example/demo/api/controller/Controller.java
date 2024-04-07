package com.example.demo.api.controller;

import com.example.demo.api.model.Facility;
import com.example.demo.api.model.Reservation;
import com.example.demo.api.model.User;
import com.example.demo.service.Services;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

class LoginRequest {
    public String email;
    public String password;
}

class addReservationBody {
    public String facilityName;
    public String time;
}
@RestController
public class Controller {

    private final Services services;

    @Autowired
    public Controller(Services services){
        this.services = services;
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest body){
        return services.login(body.email, body.password);
    }
    @GetMapping("/facilities")
    public Object getFacilities(@RequestParam String userID){
        return services.facilities(userID);
    }

    @PostMapping("/addReservation")
    public Reservation reservation(@RequestBody addReservationBody body, @RequestParam String userID){
        return  services.addReservation(body.facilityName, body.time, userID);
    }
    @GetMapping("/userReservations")
    public Object userReservations(@RequestParam String userID){
        return  services.userReservations(userID);
    }
}