package com.example.demo.api.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Faculty extends User{
    public Faculty(String id, String name, String email, String password, Gender gender) {
        super(id, name, email, password, gender);
    }

    @Override
    public ArrayList<Facility> getFaculties(ArrayList<Facility> faculties) {
        return faculties;
    }

    @Override
    public Reservation addReservation(Facility facility,Reservation reservation) {
//        no restriction for the gender so, pass it to the facility in order to save the reservation
        return facility.addReservation(reservation, getId());
    }
    @Override
    public boolean joinEvent(Facility facility, Event event) {
        return event.joinEvent(getId());
    }
}
