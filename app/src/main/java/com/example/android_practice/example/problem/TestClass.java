package com.example.android_practice.example.problem;

import java.util.Scanner;

public class TestClass extends ShowDetail{
    public static void main(String[] args) {
        Owner owner1 = new Owner();
        owner1.setOwnerName("Tosif");
        owner1.setCnicNumber(34526272);
        owner1.setPhoneNumber(989867675);
        owner1.setCc(300);
        owner1.setModel("Classic 300");
        owner1.setName("Bullet");

        Owner owner2 = new Owner("parth", 86382648, 923882694, "Honda", "Dream Neo", 150);
        Owner owner3 = new Owner("ruchit", 923688234, 723582478, "KIA", "Saltos", 700);

        ShowDetail detail = new TestClass();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        if (name.equals("Tosif")) {
            showData(owner1);
        } else if (name.equals("parth")) {
            showData(owner2);
        } else if (name.equals("ruchit")) {
            showData(owner3);
        }
    }
}
