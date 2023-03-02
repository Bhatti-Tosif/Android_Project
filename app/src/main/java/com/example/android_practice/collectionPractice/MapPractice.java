package com.example.android_practice.collectionPractice;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapPractice {
    public static void main(String[] args) {
        Map<Integer, String> number = new HashMap<>();
        Map<Integer, String> number2 = new HashMap<>();
        number.put(3, "three");
        number2.putAll(number);
        number.putIfAbsent(1, "one");
        System.out.println(number.containsKey(3));
        System.out.println(number.getOrDefault(5, "five"));
        System.out.println(number.get(5));
        number.replace(5, "five");
        System.out.println(number);
        System.out.println(number.keySet());
        System.out.println(number.values());
        System.out.println(number.entrySet());
        number.put(2, "two");
        //int result = number.compute(1, (key, value) -> key - key + 10);

        System.out.println("========Iterate through Map======== ");
        System.out.println("Print data");
        for (int no: number.keySet()) {
            System.out.print(no);
            System.out.print(", ");
        }
        //Entire hashMap
        System.out.println("\nEntry map");
        for (Map.Entry<Integer, String> entry: number.entrySet()) {
            System.out.print(entry);
            System.out.println(", ");
        }

        Set<Integer> set = new HashSet<>();
        set.add(45);
        set.add(25);
        set.add(12);
        set.add(67);
        System.out.println(set);

    }
}
