package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

    /**
     * We are given two arrays A and B of words. Each word is a string of lowercase letters.
     *
     * Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity. For example,
     * "wrr" is a subset of "warrior", but is not a subset of "world".
     *
     * Now say a word a from A is universal if for every b in B, b is a subset of a.
     *
     * Return a list of all universal words in A. You can return the words in any order.
     *
     * Example 1:
     *  Input: A = ["Amazon", "apple", "facebook", "google", "leetcode"], B = ["e", "o"]
     *  Output: ["facebook", "google", "leetcode"]
     *
     * Example 2:
     *  Input: A = ["amazon", "apple", "facebook", "google", "leetcode"], B = ["l", "e"]
     *  Output: ["apple", "google", "leetcode"]
     *
     * Example 3:
     *  Input: A = ["amazon", "apple", "facebook", "google", "leetcode"], B = ["e", "oo"]
     *  Output: ["facebook", "google"]
     *
     * Example 4:
     *  Input: A = ["amazon", "apple", "facebook", "google", "leetcode"], B = ["lo", "eo"]
     *  Output: ["google", "leetcode"]
     *
     *
     * @param a, b
     */
    public static List<String> wordSubsets(String[] a, String[] b) {
        List<String> subsets = new ArrayList<>();
        List<String> subsetsToRemove = new ArrayList<>();

        for (int x=0; x<a.length; x++) {
            String wordA = a[x];
            for (int y=0; y<b.length; y++) {
                String wordB = String.valueOf(b[y]);
                if (wordA.indexOf(wordB) == -1) {
                    subsetsToRemove.add(wordA);
                    break;
                }
            }
            subsets.add(wordA);
        }

        for (String remove: subsetsToRemove) {
            subsets.remove(remove);
        }

        return subsets;
    }

    public static void main(String[] args) {
        String[] a = {"Amazon", "apple", "facebook", "google", "leetcode"};
        String[] b = {"e", "o"};
        System.out.println(wordSubsets(a, b)); // Output: "facebook", "google", "leetcode"
    }

}
