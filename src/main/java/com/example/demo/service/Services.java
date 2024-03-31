package com.example.demo.service;

import com.example.demo.api.model.User;
import com.example.demo.api.model.Facility;
import com.example.demo.api.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Services {

    private List<User> userList;
    private List<Facility> facilityList;
    private List<Reservation> reservationList;

    public Services() {
        userList = new ArrayList<>();
        facilityList = new ArrayList<>();
        reservationList = new ArrayList<>();

        userList.add(new User(1,"a", "aa@mail.com",  "123"));
        userList.add(new User(2,"b", "b@mail.com",  "123"));
        userList.add(new User(3,"c", "c@mail.com",  "123"));

        facilityList.add(new Facility("swimming pool", "male"));
        facilityList.add(new Facility("swimming pool", "female"));

    }

    public boolean login(String email, String password){
        for (User user: userList) {
            if(email.equals(user.getEmail()) && password.equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }

    public Facility[] facilities(){
        return (Facility[]) facilityList.toArray();
    }

    public boolean addReservation(String facilityName, String gender, String timing, String userID){
        for (Facility facility: facilityList){
            if (facility.getName().equals(facilityName) && facility.getGender().equals(gender)){
                reservationList.add(new Reservation(facility, timing, userID));
                return true;
            }
        }
        return false;
    }

    public Reservation[] userReservations(String id){
        ArrayList<Reservation> userReseravtion = new ArrayList<>();

        for (Reservation reservation: reservationList){
            if (reservation.getUserID().equals(id)){
                userReseravtion.add(reservation);
            }
        }
        return (Reservation[]) userReseravtion.toArray();
    }



 }