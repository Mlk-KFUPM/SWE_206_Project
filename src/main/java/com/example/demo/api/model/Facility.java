package com.example.demo.api.model;

import java.util.ArrayList;

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

    public boolean addReservation(String timing, String userID){


        for (Reservation reservation:reservationList){
            if (reservation.getTiming().equals(timing)){
                return false;
            }
        }
        reservationList.add(new Reservation(timing,userID));
        return true;


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
