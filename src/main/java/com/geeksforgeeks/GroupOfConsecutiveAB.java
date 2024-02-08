package com.geeksforgeeks;

/*
    Given string str, the task is to check whether every group of consecutive a’s is followed by a group of consecutive b’s of the same length.
    If the condition is true for every group then print 1 else print 0.

    Examples:

    Input: str = “ababaabb”
    Output: 1
    ab, ab, aabb. All groups are valid

    Input: str = “aabbabb”
    Output: 0
    aabb, abb (A single ‘a’ followed by 2 ‘b’)
 */
public class GroupOfConsecutiveAB {

    // ababaabb
    public static int validateGroup(String str) {
        if (str.length() < 2)
            return 0;

        int groupA = 0;
        int groupB = 0;
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (groupA == 0 && c == 'b')
                return 0;
            if (c == 'a') {
                if (groupB > 0)
                    return 0;
                groupA++;
            } else { // c == 'b'
                groupB++;
                if (groupB < groupA) {
                    continue;
                } else if (groupA == groupB) {
                    // all good
                    groupA = 0;
                    groupB = 0;
                } else {
                    return 0;
                }
            }
        }

        return groupA == groupB ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(validateGroup("ababaabb")); // 1
        System.out.println(validateGroup("aabbabb")); // 0
    }

}
