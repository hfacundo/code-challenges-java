package com.algorithms;

import com.algorithms.model.TreeNode;

/***        1
 *         / \
 *        2   3
 *       / \   \
 *      4   5   6
 */
public class TreeTraversal {

    /**
     * print root, left, right
     * 1, 2, 4, 5, 3, 6
     * @param root
     */
    public static void preOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * print left, root, right
     *
     * 4, 2, 5, 1, 3, 6
     * @param root
     */
    public static void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    /**
     * print left, right, root
     *
     * 4, 5, 2, 6, 3, 1
     * @param root
     */
    public static void postOrder(TreeNode root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode right = new TreeNode(3, null, new TreeNode(6));
        TreeNode root = new TreeNode(1, left, right);
        preOrder(root);
        inOrder(root);
        postOrder(root);
    }
}
