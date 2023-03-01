package com.example.android_practice.example.problem;

public class Owner extends  Vehicle {
    String ownerName;
    long cnicNumber, phoneNumber;

    Owner() {
        ownerName = "None";
        cnicNumber = 273874457;
        phoneNumber = 838393743;
    }
    Owner(String ownerName, long cnicNumber, long phoneNumber, String name, String model, Integer cc) {
        super(name, model, cc);
        this.ownerName = ownerName;
        this.cnicNumber = cnicNumber;
        this.phoneNumber = phoneNumber;
    }

    public long getCnicNumber() {
        return cnicNumber;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setCnicNumber(long cnicNumber) {
        this.cnicNumber = cnicNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    String getOwnerName() {
        return ownerName;
    }
    void setOwnerName(String name) {
        this.ownerName = name;
    }

}
