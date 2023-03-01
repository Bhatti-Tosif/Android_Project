package com.example.android_practice.example.problem;

//Implement Vehicle as outer and owner as the inner class, the vehicle class contains
//vehicle name, engine cc, model as data members. The inner class data members areowners name, CNIC number and phone contact of the owner.Write down proper setters/ getters and constructors for both the classes.1: Override the method of a class using anonymous inner class.2: Pass an anonymous inner class as a method argument.3: Implement the inner class as static first and then as non static nested class.


public class Vehicle {
    String name, model;
    Integer cc;
    Vehicle() {
        name = "None";
        model = "null";
        cc = 0;
    }
    Vehicle(String name, String model, Integer cc) {
        this.name = name;
        this.model = model;
        this.cc = cc;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public Integer getCc() {
        return cc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }
}
