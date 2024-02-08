package com.leetcode.medium;

/**
 * Given a binary tree, find the leftmost value in the last row of the tree
 * 
 *  Example 1:
 *      Input:
 *          2
 *         / \
 *        1   3
 *        
 *       Output: 1
 */
public class FindBottomLeftTreeValue {

    public static int findBottomLeftValue(TreeNode root) {
        if (root.left == null)
            return root.val;
        return findBottomLeftValue(root.left);
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null));
        System.out.println(findBottomLeftValue(node));
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
