package com.example.android_practice.collectionPractice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class CollectionPractice {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("rahul");
        list2.add("meet");
        list2.add("harsh");
        list2.remove("meet");
        System.out.println(list2);
        list.add("tosif");
        System.out.println(list);
        String name[] = {"ruchit", "parth", "harsh"};
        System.out.println(Arrays.toString(name));
        for (String lang : name) {
            list.add(lang);
        }
        System.out.println(list);
        String newArray[] = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(newArray));
        list.get(3);
        list.remove(2);
        list.addAll(list2);
        list.set(1, "atul");
        System.out.println("Print List: " + list);
        System.out.println(list.size());
        System.out.println(list.indexOf("harsh"));

        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList.indexOf(2));

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        ArrayList<String> numbersOfName = (ArrayList<String>)list2.clone();
        //Iterate using for each loop
        for (String numberName: numbersOfName) {
            System.out.println(numberName);
        }
        System.out.println(list.contains("harsh"));

        list.sort(Comparator.naturalOrder());
        System.out.println("Sorted: "+ list);
        list2.ensureCapacity(10);
        list2.add("xyz");
        list2.add("abc");
        list2.add("ytr");
        list2.add("kshd");
        list2.add("sbbs");
        System.out.println(list2);

        list2.replaceAll(e -> e.toUpperCase());
        System.out.println(list2);
        list2.replaceAll(t -> t + "a");
        System.out.println(list2);

        System.out.println(linkedList);
        linkedList.removeIf(e -> (e % 2) ==0);
        System.out.println(linkedList);

        linkedList.forEach((e) -> {
            e *= 2;
            System.out.println("New: " + e);
        });

        //Stack Practice
        Stack<String> stack = new  Stack<String>();
        stack.add("Hello");
        stack.add("rahul");
        stack.add(1, "harsh");
        System.out.println(stack);

    }
}
