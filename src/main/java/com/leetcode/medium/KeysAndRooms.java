package com.leetcode.medium;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class KeysAndRooms {

    /**
     * There are N rooms and you start in room 0. Each room has a distinct number in 0, 1, 2,
     * ..., N-1, and each room may have some keys to access the next room.
     *
     * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1]
     * where N = rooms.length. A key rooms[i][j] = v opens the room with number v
     *
     * Initially, all the rooms start locked (except for room 0).
     *
     * You can walk back and forth between rooms freely.
     *
     * Return true if and only if you can enter every room
     *
     * Example 1:
     *  Input: [[1],[2],[3],[]]
     *  Output: true
     *  Explanation:
     *      We start in room 0, and pick up key 1.
     *      We then go to room 1, and pick up key 2.
     *      We then go to room 2, and pick up key 3.
     *      We then go to room 3. Since we were able to go to every room, we return true
     *
     * Example 2:
     *  Input: [[1, 3],[3, 0, 1],[2],[0]]
     *  Output: false
     *  Explanation:
     *      We can't enter the room with number 2
     *
     * Better explanation:
     *  Input: [[1, 3],[3, 0, 1],[2],[0]] means that [1, 3] allows reading array positions 1 and 3 which are  i=1 -> [3, 0, 1] and i=3 -> [0]
     *
     *      [[1, 3],[3, 0, 1],[2],[0]]
     *         0       1       2   3
     *
     * @param rooms
     * @return
     */
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // [[1, 3],[3, 0, 1],[2],[0]]
        //     0       1      2   3

        Set<Integer> set = new TreeSet<>();
        Stack<Integer> stack = new Stack<>();

        // initial array
        List<Integer> current = rooms.get(0);
        set.add(0);
        for (Integer num : current) {
            // this will tell us the element we already visited
            if (!set.contains(num)) {
                set.add(num);
                stack.add(num);
            }
        }

        System.out.println("set " + set);
        System.out.println("stack " + stack);

        while (!stack.isEmpty()) {
            int pos = stack.pop();
            System.out.println("extracted value from stack: " + pos);
            System.out.println("stack now -> " + stack);
            current = rooms.get(pos);
            for (Integer num : current) {
                if (!set.contains(num)) {
                    set.add(num);
                    stack.add(num);
                }
            }
        }

        System.out.println("set final value " + set);

        for (int x=0; x<rooms.size(); x++) {
            if (!set.contains(x))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // [[1],[2],[3],[]] -> true
        //System.out.println(canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), Collections.EMPTY_LIST))); // true
        // [[1, 3],[3, 0, 1],[2],[0]] -> false
        System.out.println(canVisitAllRooms(List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0)))); // false
    }

}
