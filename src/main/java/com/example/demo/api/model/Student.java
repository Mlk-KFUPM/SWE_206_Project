package com.example.demo.api.model;

import java.time.LocalDateTime;
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
    public Reservation addReservation(Facility facility, LocalDateTime startTime, LocalDateTime endTime) {
        if (getGender().equals(facility.getGender())){
            return facility.addReservation(startTime, endTime, getId());
        }else {
            return null;
        }

    }
}
