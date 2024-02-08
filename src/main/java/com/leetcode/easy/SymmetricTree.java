package com.leetcode.easy;

public class SymmetricTree {

    /**
     *       1
     *      / \
     *     2   2
     *    / \ / \
     *   3  4 4  3
     *
     *   return true
     *
     *        1
     *       / \
     *      2   2
     *       \   \
     *        3   3
     *
     *    return false
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
    
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null));
        TreeNode right = new TreeNode(2, new TreeNode(4, null, null), new TreeNode(3, null, null));
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(isSymmetric(root));
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
