package com.example.demo.api.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reservation {
    private String ID;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String userID;

    public Reservation(LocalDateTime startTimeTime, LocalDateTime endTime, String userID){
        this.startTime = startTimeTime;
        this.endTime = endTime;
        this.userID = userID;

//        create unique id
        this.ID = String.valueOf(UUID.randomUUID());
    }


    public LocalDateTime getEndTime() {
        return endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getID() {
        return ID;
    }

}
