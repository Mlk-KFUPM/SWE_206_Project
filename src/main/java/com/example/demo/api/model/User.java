package com.example.demo.api.model;

public class User {

    private String id;
    private String name;
    private String password;
    private String email;
    private Gender gender;
    private Role role;

    public enum Role {
        admin,
        student,
        faculty,
        staff,
        club_president
    }
    public enum Gender {
        male,
        female
    }


    public User(String id, String name, String email, String password, Role role, Gender gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.gender = gender;
    }
    public String getGender() {
        return gender.toString();
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}