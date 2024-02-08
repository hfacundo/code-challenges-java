package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.
 * Words in the paragraph are not case sensitive. The answer is in lowercase.
 *
 * Example:
 *  Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 *  banned = ["hit"]
 *  Output = "ball"
 *  Explanation: "hit" occurs 4 times, but it is a banned word.
 *  "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph
 *
 */
public class MostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned) {
        String result = "";
        int maxOccurrences = 0;

        Map<String, Integer> map = new HashMap<>();
        Set<String> bannedWords = Arrays.stream(banned).collect(Collectors.toSet());
        String[] words = paragraph.split(" ");

        for (String word : words) {
            if (!Character.isLetter(word.charAt(word.length()-1)))
                word = word.substring(0, word.length()-1);
            String wordToLowerCase = word.toLowerCase();
            if (bannedWords.contains(wordToLowerCase)) {
                continue;
            }
            if (map.containsKey(wordToLowerCase)) {
                map.put(wordToLowerCase, map.get(wordToLowerCase) + 1);
            } else {
                map.put(wordToLowerCase, 1);
            }
            if (map.get(wordToLowerCase) > maxOccurrences) {
                maxOccurrences = map.get(wordToLowerCase);
                result = wordToLowerCase;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(paragraph, banned));
        int[] array = {1,2,0,1};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
