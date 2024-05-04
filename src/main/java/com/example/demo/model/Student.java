package com.example.demo.model;

import java.util.ArrayList;

public class Student extends User{

    public Student(String id, String name, String email, String password, Gender gender) {
        super(id, name, email, password, gender);
    }

    @Override
    public ArrayList<Facility> getFaculties(ArrayList<Facility> faculties) {
        ArrayList<Facility> allowedFaculties = new ArrayList<>();
        for (Facility facility: faculties){
            if (getGender().equals(facility.getGender())){
                allowedFaculties.add(facility);
            }
        }
        return allowedFaculties;
    }

    @Override
    public Reservation addReservation(Facility facility, Reservation reservation) {
        if (getGender().equals(facility.getGender())){
            return facility.addReservation(reservation, getId());
        }else {
            return null;
        }
    }
    @Override
    public boolean joinEvent(Facility facility, Event event) {
        if(getGender().equals(facility.getGender())){
            return event.joinEvent(getId());
        }else {
            return false;
        }
    }
}
