package com.example.demo.api.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Facility {
    private String name;
    private ArrayList<Reservation> reservationList = new ArrayList<>();

    private Gender gender;
    public enum Gender  {
        male,
        female,
        both
    }


    public Facility(String name, Gender gender){
        this.name = name;
        this.gender = gender;
    }

    public Reservation addReservation(LocalDateTime startTime, LocalDateTime endTime, String userID){

        for (Reservation reservation:reservationList){
            LocalDateTime start2 = reservation.getStartTime();
            LocalDateTime end2 = reservation.getEndTime();
            if (!startTime.isBefore(end2) || !endTime.isAfter(start2)){
                return null;
            }
        }

        Reservation newReservaion = new Reservation(startTime, endTime, userID);

        reservationList.add(newReservaion);
        return newReservaion;
    }

    public ArrayList<Reservation> getAllReservations(){
        return reservationList;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender.toString();
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
