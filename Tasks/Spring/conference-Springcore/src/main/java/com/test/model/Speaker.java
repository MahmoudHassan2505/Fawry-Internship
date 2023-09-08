package com.test.model;

public class Speaker {
    private String firstname;
    private String lastname;
    private double id;

    public double getSeedNum() {
        return id;
    }

    public void setSeedNum(double seedNum) {
        this.id = seedNum;
    }



    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
