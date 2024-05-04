package com.example.demo.controller;

import com.example.demo.model.Reservation;
import com.example.demo.model.User;
import com.example.demo.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

class LoginRequest {
    public String email;
    public String password;
}

class addReservationBody {
    public String facilityName;
    public String startTime;
    public String endTime;
}
class createEventBody {
    public String facilityName;
    public String time;
    public String userID;
    public int number;
}
class joinEventBody {
    public String facilityName;
    public String userID;
}
class ResponseBody {
    public String message;
    ResponseBody(String message){
        this.message = message;
    }
}


@RestController
public class Controller {

    private final Services services;

    @Autowired
    public Controller(Services services){
        this.services = services;
    }
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest body){
        User user = services.login(body.email, body.password);
        System.out.println(body.email + "\t" + body.password);
        if (user == null){
            return ResponseEntity.status(401).body(new ResponseBody("password or email is not correct"));
        }else {
            return ResponseEntity.status(200).body(user);
        }

    }
    @GetMapping("/facilities")
    public Object getFacilities(@RequestParam String userID){
        return services.getFacilities(userID);
    }

    @PostMapping("/addReservation")
    public Reservation reservation(@RequestBody addReservationBody body, @RequestParam String userID){
        return  services.addReservation(body.facilityName, body.startTime, body.endTime, userID);
    }
    @GetMapping("/userReservations")
    public Object userReservations(@RequestParam String userID){
        return  services.userReservations(userID);
    }

    @PostMapping("/createEvent")
    public Object createEvent(@RequestBody createEventBody body){
        return services.createEvent(body.facilityName, body.time, body.userID, body.number);
    }

    @PostMapping("/joinEvent")
    public Object joinEvent(@RequestBody joinEventBody body){
        return services.joinEvent(body.facilityName, body.userID);
    }
}