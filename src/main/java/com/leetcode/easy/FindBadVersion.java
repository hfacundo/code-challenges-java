package com.leetcode.easy;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindBadVersion {

    private static final int BAD_VERSION = 5;

    /**
     * Suppose you have n versions of deploys -> [1, 2, 3, 4, 5, 6, 7 ... n]
     * you want to find the first bad version because once a version is bad all following ones will be also bad
     *
     * example:
     *
     * isBadVersion(1) -> false;
     * isBadVersion(2) -> false;
     * isBadVersion(3) -> false;
     * isBadVersion(4) -> true;
     * isBadVersion(5) -> true;
     * isBadVersion(6) -> true;
     * isBadVersion(7) -> true;
     *
     * first bad version is 4
     *
     * we need to call isBadVersion as less as possible
     *
     * @return
     */

    public static int findFirstBadVersion(int n) {
        int from = 0;
        int to = n;
        Queue<Integer> queue = new PriorityQueue<>();

        while (from < to) {
            int middle = from + (to - from) / 2;
            if (isBadVersion(middle)) {
                to = middle;
                queue.add(middle);
            } else {
                from = middle+1;
            }
        }

        System.out.println(queue);
        if (queue.isEmpty())
            return -1;
        return queue.peek();
    }

    // imagine this is an API call
    private static boolean isBadVersion(int version) {
        if (version >= BAD_VERSION)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findFirstBadVersion(10));
    }

}
