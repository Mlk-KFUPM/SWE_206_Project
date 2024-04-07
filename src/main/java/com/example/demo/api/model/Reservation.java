package com.example.demo.api.model;

import java.time.LocalDateTime;

public class Reservation {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String userID;

    public Reservation(LocalDateTime startTimeTime, LocalDateTime endTime, String userID){
        this.startTime = startTimeTime;
        this.endTime = endTime;
        this.userID = userID;
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

}
