package com.example.demo;

public class User {

    @NameEngOnly(message = "name invalid.")
    private String engName;

    public User() {
    }

    public User(String engName) {
        this.engName = engName;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }
}
