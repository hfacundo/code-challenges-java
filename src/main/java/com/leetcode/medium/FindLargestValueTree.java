package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Find largest value in each tree row
 *
 * Example:
 *
 *  Input:
 *        1
 *       / \
 *      3   2
 *     / \   \
 *    5   3   9
 *
 * Output: [1, 3, 9]
 *
 */
public class FindLargestValueTree {

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> largest = new ArrayList<>();
        largestRecursive(root, largest, 0); // 0 represent the current level of the tree
        return largest;
    }

    public static void largestRecursive(TreeNode root, List<Integer> largest, int level) {
        if (root == null)
            return;

        if (level == largest.size()) {
            largest.add(root.val);
        } else {
            largest.set(level, Math.max(largest.get(level), root.val));
        }

        largestRecursive(root.left, largest, level+1);
        largestRecursive(root.right, largest, level+1);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5, null, null), new TreeNode(3, null, null)),
                new TreeNode(2, null, new TreeNode(9, null, null)));
        System.out.println(largestValues(root));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    
}
