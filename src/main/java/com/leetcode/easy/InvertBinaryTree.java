package com.leetcode.easy;

public class InvertBinaryTree {

    /**
     * Invert a binary tree
     *
     * Example:
     *      Input:
     *          4
     *         / \
     *        2   7
     *       / \ / \
     *      1  3 6  9
     *
     * Output:
     *          4
     *         / \
     *        7   2
     *       / \ / \
     *      9  6 3  1
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode root = new TreeNode(1, null, node2);

        System.out.println(root);
        System.out.println();
        System.out.println(invertTree(root));

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
