package com.leetcode.easy;

public class RobotReturnToOrigin {

    /**
     * There is a robot starting at position (0,0), the origin on a 2D plane. Given a sequence of its moves,
     * judge if this robot end up at (0,0) after it completes its moves
     *
     * Example 1:
     *  Input: "UD"
     *  Output: true
     *  Explanation: The robot moves up once, and then down once. All moves have the same magnitude,
     *  so it ended up at the origin
     *
     * Example 2:
     *  Input: "LL"
     *  Output: false
     *
     * @param moves
     * @return
     */
    public static boolean judgeCircle(String moves) {
        // (0,0) -> (x, y)
        int x=0;
        int y=0;

        for (int i=0; i<moves.length(); i++) {
            // U -> UP, D -> DOWN, L -> LEFT, R -> RIGHT
            // U -> x+1, D -> x-1, L -> y-1, R -> y+1
            switch (moves.charAt(i)) {
                case 'U':
                    x++;
                    break;
                case 'D':
                    x--;
                    break;
                case 'L':
                    y--;
                    break;
                case 'R':
                    y++;
                    break;
            }
        }

        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("UD")); // true
        System.out.println(judgeCircle("LL")); // false
        System.out.println(judgeCircle("UURLRLDD")); // true
        System.out.println(judgeCircle("LLUUUURR")); // false
    }
}
