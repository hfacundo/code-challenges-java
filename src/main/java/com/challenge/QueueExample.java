package com.challenge;

import java.util.*;

public class QueueExample {

    public void linkedListExample() {
        Queue<String> queue = new LinkedList<>();
        queue.add("element");
        queue.add("element2");
        queue.add("element1");
        System.out.println(queue.peek()); // reads but doesn't remove
        System.out.println(queue.poll()); // reads and remove
        System.out.println(queue.size());
        //queue.forEach(System.out::println);
    }

    public void priorityQueueExample() {
        Queue<String> queue = new PriorityQueue<>();
        queue.add("element");
        queue.add("element2");
        queue.add("element1");
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.size());
    }

    public void dequeueExample() {
        Deque<String> test = new ArrayDeque<>();
        test.add("element 1");
        test.add("element 4");
        test.add("element 0");
        test.add("element 3");
        System.out.println(test);
        System.out.println(test.getFirst());
        System.out.println(test.getLast());
    }

    public void priorityQueueExampleReverse() {
        Queue<String> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.add("element");
        queue.add("element2");
        queue.add("element1");
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.size());
    }

    public static void main(String[] args) {
        QueueExample q = new QueueExample();
        //q.linkedListExample();
        q.priorityQueueExample();
        System.out.println();
        q.dequeueExample();
        System.out.println();
        q.priorityQueueExampleReverse();
    }
}
