package com.leetcode.easy;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoBinaryTrees {

    /**
     * Given two binary trees and imagine that when you put one of them to cover the other, some nodes
     * of the two trees are overlapped while the others are not.
     *
     * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then
     * sum node values up as the new value of the merged node. Otherwise, the NOT null node will be
     * used as the node of new tree.
     *
     * Example 1:
     *
     * Input:
     *      Tree 1                  Tree 2
     *        1                       2
     *       / \                     / \
     *      3   2                   1   3
     *     /                         \   \
     *    5                           4   7
     *
     * Output:
     * Merged tree:
     *              3
     *             / \
     *            4   5
     *           / \   \
     *          5   4   7
     *
     * @param t1
     * @param t2
     * @return
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        List<Integer> result = new ArrayList<>();
        mergeTreeRecursive(result, t1, t2);
        System.out.println(result);
        return null;
    }

    public static TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val+=t2.val;
        t1.left = mergeTrees2(t1.left, t2.left);
        t1.right = mergeTrees2(t1.right, t2.right);
        return t1;


    }

    // first approach, result is not accurate
    public static void mergeTreeRecursive(List<Integer> result, TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return;
        } else if (t1 == null && t2 != null) {
            result.add(t2.val);
            mergeTreeRecursive(result, null, t2.left);
            mergeTreeRecursive(result, null, t2.right);
        } else if (t1 != null && t2 == null) {
            result.add(t1.val);
            mergeTreeRecursive(result, t1.left, null);
            mergeTreeRecursive(result, t1.right, null);
        } else {
            result.add(t1.val + t2.val);
            mergeTreeRecursive(result, t1.left, t2.left);
            mergeTreeRecursive(result, t1.right, t2.right);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1, new TreeNode(3, new TreeNode(5, null, null), null), new TreeNode(2, null, null));
        TreeNode t2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4, null, null)), new TreeNode(3, null, new TreeNode(7, null, null)));
        // mergeTrees(t1, t2);
        System.out.println(mergeTrees2(t1, t2));
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
