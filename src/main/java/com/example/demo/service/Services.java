package com.example.demo.service;

import com.example.demo.api.model.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class Services {

    private ArrayList<User> userList;
    private ArrayList<Facility> facilityList;
    private List<Event> EventList;

    public Services() {
//        these list works like a database, which stores the data of the system
        userList = new ArrayList<>();
        facilityList = new ArrayList<>();
        EventList = new ArrayList<>();

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
        return user.getFaculties(facilityList);

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
                return user.addReservation(facility, startTime, endTime);

            }
        }
        return null;

    }

    public Object userReservations(String userID){
        User user = findUser(userID);

        Object list = user.getReservations(facilityList);
        return list;
    }


    public Object createEvent(String facilityName, String time, String userID, int targetNumber){
//        ###### we have to check if this event has been created or not ######

//        get the start time by parsing and get the end time by increment the hour by one
//        (it will be changed later)
        LocalDateTime startTime = LocalDateTime.parse(time);
        LocalDateTime endTime = LocalDateTime.of(startTime.getYear(), startTime.getMonth(), startTime.getDayOfMonth(), startTime.getHour()+1, startTime.getMinute());

//        1 - find the facility
//        2 - get the user and check the gender with the facility

        User user = findUser(userID);

        for (Facility facility: facilityList){
            if (facility.getName().equals(facilityName)){
                if ( user.getGender().equals(facility.getGender())) {
                    return EventList.add(new Event(facility, startTime,endTime,userID,targetNumber));

                }else {
                    return null;
                }
            }

        }
        return null;
    }

    public Object joinEvent(String facilityName, String userID){
        for (Event event: EventList){
            if (event.getFacility().getName().equals(facilityName)){
                event.joinEvnet(userID);
//                if we reach the wanted number of user in the event, we want to create a reservation of it
                if (event.getTargetNumber() == event.getParticipants()){
                    addReservation(facilityName, String.valueOf(event.getStartTime()), String.valueOf(event.getStartTime()), event.getCreaterID());
                    EventList.remove(event);
                }
                return "the user has join the event";
            }
        }
        return "something went wrong";
    }
 }