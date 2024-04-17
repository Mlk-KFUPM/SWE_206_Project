package com.example.demo.api.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Event {
    private Facility facility;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String createrID;
    private int participants = 1;
    private int targetNumber;
    private ArrayList<String> participantsID = new ArrayList<>();

    public Event(Facility facility, LocalDateTime startTimeTime, LocalDateTime endTime, String userID, int targetNumber){
        this.facility = facility;
        this.startTime = startTimeTime;
        this.endTime = endTime;
        this.createrID = userID;
        this.targetNumber = targetNumber;
    }

    public void joinEvnet(String userID) {
        this.participants = this.participants + 1;
        this.participantsID.add(userID);
    }

    public int getParticipants() {
        return participants;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getCreaterID() {
        return createrID;
    }

    public void setCreaterID(String userID) {
        this.createrID = userID;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

}
