package com.example.demo.service;

import com.example.demo.api.model.*;
import com.example.demo.model.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class Services {

    private ArrayList<User> userList;
    private ArrayList<Facility> facilityList;

    public Services() {
//        these list works like a database, which stores the data of the system
        userList = new ArrayList<>();
        facilityList = new ArrayList<>();

        userList.add(new Admin("1","a", "aa@mail.com",  "123", User.Gender.male));
        userList.add(new Student("2","b", "b@mail.com",  "123", User.Gender.male));
        userList.add(new Student("3","c", "c@mail.com",  "123", User.Gender.female));

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

//    getFacilities() works : but Student class will return the Both gender in the list
    public Object getFacilities(String userID){

        User user = findUser(userID);
        return user.getFaculties(facilityList); // to restrict Male or Female

    }

//    addReservation() works : but Student class will add Faculty that is Both gender
    public Reservation addReservation(String facilityName, String startAt, String endAt, String userID){
//        Example of time that should be pass to this method :
//            startAt = "2024-04-07T15:30";
//            endAt = "2024-04-07T16:30";

        LocalDateTime startTime = LocalDateTime.parse(startAt);
        LocalDateTime endTime = LocalDateTime.parse(endAt);

//        Get the user using a method called findUser
        User user = findUser(userID);

        for (Facility facility: facilityList){
            if (facility.getName().equals(facilityName)){
                Reservation reservation = new Reservation(startTime, endTime, user.getId());
                return user.addReservation(facility, reservation);

            }
        }
        return null;

    }

    public Object createEvent(String facilityName, String startAt, String endAt, String userID, int targetNumber){
        LocalDateTime startTime = LocalDateTime.parse(startAt);
        LocalDateTime endTime = LocalDateTime.parse(endAt);
        User user = findUser(userID);

        for (Facility facility: facilityList){
            if (facility.getName().equals(facilityName)){
                Event event = new Event(startTime, endTime, user.getId(), targetNumber);
                return user.addReservation(facility, event);
            }
        }
        return null;
    }

    public Object joinEvent(String eventID, String userID){
        User user = findUser(userID);

        for (Facility facility: facilityList){

            for (Reservation reservaion:facility.getAllReservations()){

                if (reservaion.getID().equals(eventID)){
                    return user.joinEvent(facility, (Event) reservaion);
                }
            }
        }
        return null;

    }

    public Object userReservations(String userID){
//        it is like the history of the user reservations
        User user = findUser(userID);

        Object list = user.getReservations(facilityList);
        return list;
    }



//    these methods are for admins only
    public void addFacilty(String userID){
        User user = findUser(userID);
        if (user instanceof Admin){
            ((Admin) user).addFacilty(facilityList);
        }else {
            System.out.println("the id do not belonged to an admin");
        }
    }
    public void deleteFacilty (String userID){
        User user = findUser(userID);
        if (user instanceof Admin){
            ((Admin) user).addFacilty(facilityList);
        }else {
            System.out.println("the id do not belonged to an admin");
        }
    }

 }