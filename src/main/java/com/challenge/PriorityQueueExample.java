package com.challenge;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Predicate;

public class PriorityQueueExample {

    public static int cookies(int k, List<Integer> cookies) {

        System.out.println(cookies);
        if (cookies.size() < 2)
            return -1;

        int iterations = 0;
        Queue<Integer> queue = new PriorityQueue<>();

        for (Integer cookie : cookies) {
            queue.add(cookie);
        }

        while (queue.size() > 0) {
            if (queue.peek() > k)
                return iterations;
            if (queue.size() >= 2) {
                int cookie1 = queue.poll();
                int cookie2 = queue.poll();
                int special = cookie1 + (2 * cookie2);
                queue.add(special);
                iterations++;
            } else {
                return -1;
            }
        }

        System.out.println(iterations);
        return iterations;
    }

    public static void main(String[] args) {
        Predicate<String> predicate = s -> s.length() > 1;
        String str = "hi";
        boolean value = predicate.test(str);
        System.out.println("predicate " + value);
    }
}
