package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Given an array A of strings made only from lowercase letters, return a list of all characters
 * that show up in all strings within the list (including duplicates). For example, if a character
 * occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
 *
 * You may return the answer in any order
 *
 * Example 1:
 *  Input: ["bella", "label", "roller"]
 *  Output: ["e", "l", "l"]
 *
 * Example 2:
 *  Input: ["cool", "lock", "cook"]
 *  Output: ["c", "o"]
 */
public class FindCommonCharacters {

    public static List<String> commonChars(String[] a) {
        List<String> result = new ArrayList<>();
        List<Map<Character, Integer>> chars = new ArrayList<>();

        for (int x=0; x<a.length; x++) {
            Map<Character, Integer> map = new HashMap<>();
            String currentString = a[x];
            for (int y=0; y<currentString.length(); y++) {
                char c = currentString.charAt(y);
                if (map.containsKey(c)) {
                    // update value +1
                    map.put(c, map.get(c)+1);
                } else {
                    map.put(c, 1);
                }
            }
            chars.add(map);
        }

        Map<Character, Integer> first = chars.get(0);
        chars.remove(0);

        for (Map.Entry<Character, Integer> entry : first.entrySet()) {
            boolean isPresent = true;
            Character key = entry.getKey();
            int minOccurrences = entry.getValue();

            for (Map<Character, Integer> map : chars) {
                if (map.containsKey(key)) {
                    minOccurrences = Math.min(minOccurrences, map.get(key));
                } else {
                    isPresent = false;
                    break;
                }
            }

            if (isPresent) {
                for (int x=0; x<minOccurrences; x++) {
                    result.add(String.valueOf(key));
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        String[] a = {"bella", "label", "roller"};
        System.out.println(commonChars(a));
        a = new String[] {"cool", "lock", "cook"};
        System.out.println(commonChars(a));
    }

}
