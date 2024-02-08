package com.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Alice has a hand of cards, given as an array of integers
 *
 * Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
 *
 * Return true if and only if she can
 *
 * Example 1:
 *  Input: hand = [1, 2, 3, 6, 2, 3, 4, 7, 8], W = 3
 *  Output: true
 *  Explanation: Alice's hand can be rearranged as [1, 2, 3], [2, 3, 4], [6, 7, 8].
 *
 * Example 2:
 *  Input: hand = [1, 2, 3, 4, 5], W = 4
 *  Output: false
 *  Explanation: Alice's hand can't be rearranged into groups of 4.
 *
 */
public class HandOfStraights {

    // [1, 2, 2, 3, 3, 4, 6, 7, 8]
    public static boolean isNStraightHand(int[] hand, int w) {
        Arrays.sort(hand);

        Set<Integer> visited = new TreeSet<>();
        int groups = 0;

        for (int x=0; x<hand.length; x++) {
            if (visited.contains(hand[x]))
                continue;
            if (groups >= w)
                return true;
            visited.add(hand[x]);

            int count = 1;
            int from = x+1;
            int current = hand[x];
            while (from < hand.length && count < w) {
                if (current == hand[from]) {
                    // skip
                } else if (current+1 == hand[from]) {
                    // good
                    current = hand[from];
                    count++;
                } else {
                    // exit
                    from = hand.length;
                }
                from++;
            }
            if (count == w)
                groups++;
        }

        return groups >= w;
    }

    // [1, 2, 2, 3, 3, 4, 6, 7, 8]
    // [1, 2, 3, 4, 6, 7, 8]
    public static boolean isNStraightHandSimplified(int[] hand, int w) {
        Set<Integer> set = Arrays.stream(hand).boxed().collect(Collectors.toSet());

        int groups = 0;
        int consecutive = 1;
        int last = -1;
        for (Integer num : set) {
            if (last == -1) {
                last = num;
                continue;
            }
            if (num == last+1) {
                consecutive++;
            } else {
                consecutive = 1;
            }

            last = num;
            if (consecutive >= 3) {
                groups++;
            }
        }

        return groups >= w;
    }

    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int w = 3;
        //System.out.println(isNStraightHand(hand, w)); // true
        System.out.println(isNStraightHandSimplified(hand, w)); // true

        hand = new int[]{1, 2, 3, 4, 5};
        w = 4;
        System.out.println(isNStraightHandSimplified(hand, w)); // false
    }
}
