package com.example.demo.model;

import java.time.LocalDateTime;
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

    public Reservation addReservation(Reservation reservation, String userID){
//        here to check if there is any conflict with the time
        LocalDateTime startTime = reservation.getStartTime();
        LocalDateTime endTime = reservation.getEndTime();

        for (Reservation element : reservationList){

            LocalDateTime startReservationtime = element.getStartTime();
            LocalDateTime endReservationtime = element.getEndTime();
//            check if they are any conflict
            if ((startTime.isBefore(endReservationtime) && startTime.isAfter(startReservationtime)) ||
                    (endTime.isAfter(startReservationtime) && endTime.isBefore(endReservationtime))) {
                return null;
            }
//            if the two times are equal
            if (startTime.equals(startReservationtime) || endTime.equals(endReservationtime)){
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
