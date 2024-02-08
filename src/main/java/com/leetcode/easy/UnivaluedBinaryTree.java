package com.leetcode.easy;

import java.util.Stack;

/**
 * A binary tree is univalued if every node in the tree has the same value
 * 
 * Return true if and only if the given tree is univalued
 *
 * Example 1:
 *          1
 *         / \
 *        1   1
 *       / \   \
 *      1   1   1
 *
 *      Output: true
 *
 *  Example 2:
 *         1
 *        / \
 *       1   1
 *      / \   \
 *     1   2   1
 *
 *     Output: false
 */
public class UnivaluedBinaryTree {

    public static boolean isUnivalTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int val = root.val;

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (val != current.val)
                return false;
            if (current.left != null)
                stack.add(current.left);
            if (current.right != null)
                stack.add(current.right);
        }

        return true;
    }

    public static boolean isUnivalTreeRecursive(TreeNode root) {
        boolean left = root.left == null || root.left.val == root.val &&
                isUnivalTree(root.left);
        boolean right = root.right == null || root.right.val == root.val &&
                isUnivalTree(root.right);
        return left && right;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(1, new TreeNode(1, null, null), new TreeNode(1, null, null));
        TreeNode right = new TreeNode(1, null, new TreeNode(1, null, null));
        TreeNode node = new TreeNode(1, left, right);
        System.out.println(isUnivalTree(node));
        System.out.println(isUnivalTreeRecursive(node));
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
