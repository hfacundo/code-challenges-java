package com.leetcode.medium;

/**
 * Given a non-negative integer num represented as a string, remove k digits from the number
 * so that the new number is the smallest possible
 *
 * Note:
 *  * The length of num is less than 10002 and will be >= k
 *  * The given num does not contain any leading zero
 *
 *  Example 1:
 *      Input: num = 1432219, k = 3
 *      Output: "1219"
 *      Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 *
 *  Example 2:
 *      Input: num = "10200", k = 1
 *      Output: "200"
 *      Explanation: Remove the leading 1 and the number is 200. Note that
 *      the output must not contain leading zeroes.
 *
 */
public class RemoveKDigits {

    // 1432219, k = 3 -> 1219
    // 132219
    // 12219
    // 1219

    // 4132539, k = 4 ->
    // 132539
    // 12539
    // 1239
    // 123
    public static String removeDigits(String num, int k) {

        int prev = Integer.MAX_VALUE;
        while (k > 0) {
            int temp = k;
            for (int i=0; i<num.length(); i++) {
                int digit = Integer.parseInt(String.valueOf(num.charAt(i)));
                if (prev == Integer.MAX_VALUE) {
                    prev = digit;
                    i++;
                    continue;
                }
                if (digit <= prev) {
                    num = reduceString(num, i);
                    prev = Integer.MAX_VALUE;
                    k--;
                } else {
                    prev = digit;
                }
                i++;
            }
            if (temp == k) {
                // remove last k elements
                num = num.substring(0, num.length() - k);
            }
        }

        return num;
    }

    public static String reduceString(String num, int indexToOmit) {
        return num.substring(0, indexToOmit).concat(num.substring(indexToOmit+1));
    }

    public static void test(String s, int from, int to) {
        from++;
        to--;
        System.out.println(from);
        System.out.println(to);
    }

    public static void main(String[] args) {
        System.out.println(removeDigits("1432219", 3)); // 1219
    }
}
