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
    public Reservation addReservation(Facility facility,Reservation reservation) {
//        no restriction for the gender so, pass it to the facility in order to save the reservation
        return facility.addReservation(reservation, getId());
    }

    @Override
    public boolean joinEvent(Facility facility, Event event) {
        return event.joinEvent(getId());
    }

    public void addFacilty(ArrayList<Facility> faculties){
        faculties.add(new Facility("Test", Facility.Gender.male));
    }
    public void deleteFacilty(ArrayList<Facility> faculties){
//        faculties.remove();
    }
}
