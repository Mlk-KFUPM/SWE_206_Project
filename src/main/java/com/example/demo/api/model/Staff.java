package com.example.demo.api.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Staff extends User{
    public Staff(String id, String name, String email, String password, Gender gender) {
        super(id, name, email, password, gender);
    }

    @Override
    public ArrayList<Facility> getFaculties(ArrayList<Facility> faculties) {
        return faculties;
    }

    @Override
    public Reservation addReservation(Facility facility, LocalDateTime startTime, LocalDateTime endTime) {
        return facility.addReservation(startTime, endTime, getId());
    }
}
