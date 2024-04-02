package com.example.demo.api.model;

public class Reservation {
    private String timing;
    private String userID;

    public Reservation(String timing, String userID){
        this.timing = timing;
        this.userID = userID;
    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }
}
