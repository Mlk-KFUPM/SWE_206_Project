package com.example.demo.api.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Event extends Reservation{
    private int targetNumber;
    private boolean confirmed = false;
    private ArrayList<String> participantIDs = new ArrayList<>();
    public Event(LocalDateTime startTimeTime, LocalDateTime endTime, String userID, int target) {
        super(startTimeTime, endTime, userID);
        this.targetNumber = target;
    }

    public boolean joinEvent(String userID){
        if (!confirmed){
            participantIDs.add(userID);
            return true;
        }else {
            return false;
        }

    }
    public void checkNumber(){
        if (participantIDs.size() == targetNumber){
            confirmed = true;
        }
    }

    public int getParticipantsNumber(){
        return participantIDs.size();
    }
    public ArrayList<String> getParticipantIDs() {
        return participantIDs;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(int targetNumber) {
        this.targetNumber = targetNumber;
    }
}
