package com.example.android_practice.example.problem;

abstract public class ShowDetail extends Owner {

   static void showData(Owner owner) {
        System.out.println("Name of Owner: " + owner.getOwnerName());
        System.out.println("CNIC number: " + owner.getCnicNumber());
        System.out.println("Phone Number: " + owner.getPhoneNumber());
        System.out.println("Vehicle Name: " + owner.getName());
        System.out.println("CC: " + owner.getCc());
        System.out.println("Model Name: " + owner.getModel());
    }
}
