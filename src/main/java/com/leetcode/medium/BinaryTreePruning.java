package com.leetcode.medium;

/**
 * We are given the head node root of a binary tree, where additionally every node's value is either 0 or 1.
 * 
 * Return the same three where every subtree (of the given tree) not containing a 1 has been removed
 * 
 * Example 1:
 *  Input: [1, null, 0, 0, 1]
 *  Output: [1, null, 0, null, 1]
 *  
 *  Explanation:
 *      Only the red nodes satisfy the property "every subtree not containing a 1"
 *      
 *      The diagram on the right represents the answer
 *      
 *  1                      1
 *   \                      \
 *    0         ---->        0
 *   / \                      \
 *  0   1                      1
 *  
 */
public class BinaryTreePruning {

    public static TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;
        containsOne(root);
        return root;
    }

    public static boolean containsOne(TreeNode node) {
        if (node == null) return false;
        boolean leftContains = containsOne(node.left);
        boolean rightContains = containsOne(node.right);
        if (!leftContains)
            node.left = null;
        if (!rightContains)
            node.right = null;
        return node.val == 1 || leftContains || rightContains;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(0, new TreeNode(0, null, null), new TreeNode(1, null, null)));
        System.out.println(pruneTree(root));
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
