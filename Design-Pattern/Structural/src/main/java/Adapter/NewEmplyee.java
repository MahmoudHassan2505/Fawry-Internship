package Adapter;

public class NewEmplyee {
    private String FirstName;
    private String SurName;
    private double Wage;

    public NewEmplyee(String firstName,String surName,double wage){
        this.FirstName=firstName;
        this.SurName=surName;
        this.Wage=wage;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getSurName() {
        return SurName;
    }

    public double getWage() {
        return Wage;
    }


}
