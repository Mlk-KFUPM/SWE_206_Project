package com.example.demo.api.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class User {

    private String id;
    private String name;
    private String password;
    private String email;
    private Gender gender;

    public enum Gender {
        male,
        female
    }


    public User(String id, String name, String email, String password, Gender gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public abstract ArrayList<Facility> getFaculties(ArrayList<Facility> faculties);

    public  abstract Reservation addReservation(Facility facility, LocalDateTime startTime, LocalDateTime endTime);

    public Object getReservations(List<Facility> facilities){
        Map<String , List<Reservation>> userReservations = new HashMap<>();
//        ArrayList<Reservation> userReservations = new ArrayList<>();

        for (Facility facility: facilities){
            for (Reservation reservation: facility.getAllReservations()){
                if (reservation.getUserID().equals(getId())){
                    userReservations.computeIfAbsent(facility.getName(),k -> new ArrayList<>()).add(reservation);
                }
            }
        }
        return userReservations;
    }

    public String getGender() {
        return gender.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}