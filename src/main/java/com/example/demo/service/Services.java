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

    public Services() {
        userList = new ArrayList<>();
        facilityList = new ArrayList<>();

        userList.add(new User("1","a", "aa@mail.com",  "123", User.Role.student, User.Gender.male));
        userList.add(new User("2","b", "b@mail.com",  "123", User.Role.club_president, User.Gender.male));
        userList.add(new User("3","c", "c@mail.com",  "123", User.Role.faculty, User.Gender.female));

        facilityList.add(new Facility("swimming pool", Facility.Gender.both));
        facilityList.add(new Facility("swimming pool 2", Facility.Gender.male));

    }
    public User findUser(String id){
        for (User user:userList){
            if (user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    public boolean login(String email, String password){
        for (User user: userList) {
            if(email.equals(user.getEmail()) && password.equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }

    public Object facilities(String userID){


        User user = findUser(userID);
        if (user.getRole() != User.Role.admin){

            List<Facility> data = new ArrayList<>();
            for (Facility facility:facilityList){

                if (facility.getGender().equals(user.getGender()) || facility.getGender().equals("both")){
                    data.add(facility);
                }
            }

            return data.toArray();

        }else {
            return facilityList.toArray();
        }

    }

    public boolean addReservation(String facilityName, String timing, String userID){

        User user = findUser(userID);

        for (Facility facility: facilityList){

            if (facility.getName().equals(facilityName)){
                if ( user.getGender().equals(facility.getGender()) || facility.getGender().equals("both")) {
                    return facility.addReservation(timing, userID);
                }
            }

        }
        return false;
    }

    public Object userReservations(String id){
        List<Reservation> userReseravtion = new ArrayList<>();

        for (Facility facility: facilityList){
            for (Reservation reservation: facility.getAllReservations()){
                if (reservation.getUserID().equals(id)){
                    userReseravtion.add(reservation);
                }
            }
        }

        return userReseravtion.toArray();
    }



 }