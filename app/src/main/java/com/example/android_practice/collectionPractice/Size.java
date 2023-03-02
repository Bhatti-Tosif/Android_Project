package com.example.android_practice.collectionPractice;

import java.util.EnumMap;

class  SizeEnum{
enum Size {
            SMALL, MEDIUM, LARGE
        }

    public static void main(String[] args) {
        EnumMap<Size, Integer> enumTry = new EnumMap<>(Size.class);
        enumTry.put(Size.SMALL, 20);
        enumTry.put(Size.LARGE, 100);
        enumTry.put(Size.MEDIUM, 50);
        System.out.println(enumTry);
    }
}

