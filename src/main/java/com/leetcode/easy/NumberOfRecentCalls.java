package com.leetcode.easy;

/**
 * Write a class RecentCounter to count recent requests.
 *
 * It has only one method: ping(int t), where t represents some time in miliseconds.
 *
 * Return the number of pings that have been made from 3000 milliseconds ago until now.
 *
 * Any ping with time in [t-3000, t] will count, including the current ping.
 *
 * It is guaranteed that every call to ping uses a strictly larger value of t than before.
 *
 * Example 1:
 *  Input: inputs = ["RecentCounter", "ping", "ping", "ping", "ping"],
 *  inputs = [[], [1], [100], [3001], [3002]]
 *  output: [null, 1, 2, 3, 3]
 *
 */
public class NumberOfRecentCalls {


    public static void main(String[] args) {

    }

}
