package com.example.demo.api.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Admin extends User{

    public Admin(String id, String name, String email, String password, Gender gender) {
        super(id, name, email, password, gender);
    }

    @Override
    public ArrayList<Facility> getFaculties(ArrayList<Facility> faculties) {
//        the admin have no restriction
        return faculties;
    }


    @Override
    public Reservation addReservation(Facility facility, LocalDateTime startTime, LocalDateTime endTime) {
//        admin does not have any restriction
        return facility.addReservation(startTime, endTime, getId());
    }
}
