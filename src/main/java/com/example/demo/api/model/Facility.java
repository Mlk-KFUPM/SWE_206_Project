package com.example.demo.api.model;

import java.util.Date;

public class Facility {
    private String name;
    private String gender;

    public Facility(String name, String gender){
        this.name = name;
        this.gender = gender;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
