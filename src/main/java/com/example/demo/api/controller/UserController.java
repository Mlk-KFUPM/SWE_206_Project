package com.example.demo.api.controller;

import com.example.demo.api.model.Facility;
import com.example.demo.api.model.Reservation;
import com.example.demo.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// we want 6 api routes
/*
        localhost:8080/api

/login ?username= & password=

/facilities

/reservation ?facilityName= & gender= & timing= & userID=

/userReservations ?userID=

/createEvent ?userID= & facilityId= & time=

/joinEvent ?userID= & eventId=



*/
@RestController
public class UserController {

    private final Services services;

    @Autowired
    public UserController(Services services){
        this.services = services;
    }

    @GetMapping("/login")
    public boolean login(@RequestParam String email, @RequestParam String password){
        return  services.login(email, password);
    }
    @GetMapping("/facilities")
    public Object getFacilities(){
        return services.facilities();
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