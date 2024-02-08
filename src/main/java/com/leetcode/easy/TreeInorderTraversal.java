package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class TreeInorderTraversal {

    /**
     * Inorder traversal go all to the left, then root, finally right
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursiveTraversal(result, root);
        return result;
    }

    public static void recursiveTraversal (List<Integer> result, TreeNode node) {
        if (node == null)
            return;
        recursiveTraversal(result, node.left);
        result.add(node.val);
        recursiveTraversal(result, node.right);
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode root = new TreeNode(1, null, node2);
        //System.out.println(root);
        System.out.println(inorderTraversal(root));
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
