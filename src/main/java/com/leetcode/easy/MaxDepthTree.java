package com.leetcode.easy;

public class MaxDepthTree {

    public static int maxDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepthRecursive(root.left);
            int rightDepth = maxDepthRecursive(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(1, node2, node3);

        int maxDepth = maxDepthRecursive(root);
        System.out.println(maxDepth);
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
