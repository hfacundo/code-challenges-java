package com.algorithms;

import com.algorithms.model.TreeNode;

import java.util.Stack;

public class DepthFirstSearch {

    /**
     * This algorithm print root, then go all to the left, print and then go to the right
     *          1
     *         / \
     *        2   3
     *       / \   \
     *      4   5   6
     *
     * Output: 1, 2, 4, 5, 3, 6
     * @param root
     */
    public static void depthFirstSearch(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.println(current.value);
            if (current.right != null) {
                stack.add(current.right);
            }
            if (current.left != null) {
                stack.add(current.left);
            }
        }
    }

    /**
     * This algorithm print root, then go all to the left, print and then go to the right
     *          1
     *         / \
     *        2   3
     *       / \   \
     *      4   5   6
     *
     * Output: 1, 2, 4, 5, 3, 6
     * @param root
     */
    public static void depthFirstSearchRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        depthFirstSearchRecursive(root.left);
        depthFirstSearchRecursive(root.right);
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode right = new TreeNode(3, null, new TreeNode(6));
        TreeNode root = new TreeNode(1, left, right);
        //depthFirstSearch(root);
        depthFirstSearchRecursive(root);
    }

}
