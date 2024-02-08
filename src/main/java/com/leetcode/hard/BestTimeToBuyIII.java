package com.leetcode.hard;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class BestTimeToBuyIII {

    public static int maxProfit(int[] prices) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int transactions = 0;
        int low = Integer.MIN_VALUE;
        int prev = Integer.MIN_VALUE;
        for (int current: prices) {
            if (prev == Integer.MIN_VALUE) {
                low = current;
            } else if (current <= prev) {
                if (current < prev)
                    transactions++;
                low = current;
            } else {
                queue.add(current - low);
            }
            prev = current;
        }
        System.out.println(queue);
        System.out.println(transactions);
        if (queue.isEmpty())
            return 0;
        if (queue.size() == 1)
            return queue.poll();
        if (transactions <= 1)
            return queue.poll();
        return queue.poll() + queue.poll();
    }

    public static void main(String[] args) {
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        System.out.println(maxProfit(prices));
    }
}
