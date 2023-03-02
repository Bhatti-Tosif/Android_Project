package com.example.android_practice.collectionPractice;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueuePractice {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(10);
        queue.offer(20);
        queue.offer(45);
        System.out.println(queue.peek());
        System.out.println(queue.poll() + " After: " + queue);

        System.out.println("==========PriorityQueue=================");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(23);
        priorityQueue.offer(45);
        priorityQueue.offer(12);
        Queue<String> stringQueue = new PriorityQueue<>();
        stringQueue.offer("hello");
        stringQueue.offer("ruchit");
        stringQueue.offer("atul");
        stringQueue.offer("parth");
        System.out.println(priorityQueue);
        System.out.println(stringQueue);

        System.out.println("===========ArraydeQueue============");
        ArrayDeque<Integer> dequeue = new  ArrayDeque<Integer>();
        dequeue.addFirst(10);
        dequeue.offer(30);
        dequeue.offer(45);
        dequeue.addLast(29);
        dequeue.addFirst(13);
        System.out.println("Initial Dequeue: " + dequeue);

        //Dequeue As a Stack
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("tosif");
        stack.push("harsh");
        stack.push("rahul");
        System.out.println("initial stack: " + stack);
        stack.pop();
        stack.addFirst(String.valueOf(45));
        stack.addLast("ruchit");
        System.out.println("After Stack: " + stack);

        //Array Blocking Queue:
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.add(56);
        blockingQueue.offer(53);
        blockingQueue.offer(23);
        System.out.println(blockingQueue.offer(45));
        //blockingQueue.add(56); give an Exception.

    }
}
