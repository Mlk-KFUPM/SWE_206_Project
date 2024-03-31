package com.example.demo.api.model;

public class Reservation {
    private Facility facility;
    private String timing;
    private String userID;

    public Reservation(Facility facility, String timing, String userID){
        this.facility = facility;
        this.timing = timing;
        this.userID = userID;
    }

    public Facility getFacility() {
        return facility;
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

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
