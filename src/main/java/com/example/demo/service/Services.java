package com.example.demo.service;

import com.example.demo.api.model.User;
import com.example.demo.api.model.Facility;
import com.example.demo.api.model.Reservation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

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

    public User login(String email, String password){
        for (User user: userList) {
            if(email.equals(user.getEmail()) && password.equals(user.getPassword())){
                return user;
            }
        }
        return null;
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

    public Reservation addReservation(String facilityName, String time, String userID){
//            time = "2024-04-07T15:30";

//        the difference between startTime and endTime is 1 Hour only
        LocalDateTime startTime = LocalDateTime.parse(time);
        LocalDateTime endTime = LocalDateTime.of(startTime.getYear(), startTime.getMonth(), startTime.getDayOfMonth(), startTime.getHour()+1, startTime.getMinute());

        User user = findUser(userID);

        if (user.getRole() == User.Role.student || user.getRole() == User.Role.club_president){

            for (Facility facility: facilityList){
                if (facility.getName().equals(facilityName)){
                    if ( user.getGender().equals(facility.getGender())) {
                        return facility.addReservation(startTime, endTime, userID);
                    }
                }

            }
        }
        else {
            for (Facility facility: facilityList){
                if (facility.getName().equals(facilityName)){
                    return facility.addReservation(startTime, endTime, userID);
                }
            }
        }
        return null;
    }

    public Object userReservations(String id){
        Map<String , List<Reservation>> userReseravtion = new HashMap<>();

        for (Facility facility: facilityList){
            for (Reservation reservation: facility.getAllReservations()){
                if (reservation.getUserID().equals(id)){
                    userReseravtion.computeIfAbsent(facility.getName(),k -> new ArrayList<>()).add(reservation);
                }
            }
        }

        return userReseravtion;
    }



 }