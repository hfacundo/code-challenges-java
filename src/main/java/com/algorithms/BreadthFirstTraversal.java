package com.algorithms;

import com.algorithms.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTraversal {

    /**
     * This algorithm print root and then every element in lower levels until all elements are visited
     *          1
     *         / \
     *        2   3
     *       / \   \
     *      4   5   6
     *
     * Output: 1, 2, 3, 4, 5, 6
     * @param root
     */
    public static void breadthFirstPrint(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.value);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static int countTreeLevels(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levels = 0;


        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            while (queueSize > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                queueSize--;
            }

            levels++;
        }

        return levels;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode right = new TreeNode(3, null, new TreeNode(6));
        TreeNode root = new TreeNode(1, left, right);
        //breadthFirstPrint(root);
        System.out.println(countTreeLevels(root));
    }
}
