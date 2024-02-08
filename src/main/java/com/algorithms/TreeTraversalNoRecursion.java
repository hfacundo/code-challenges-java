package com.algorithms;

import com.algorithms.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***        1
 *         / \
 *        2   3
 *       / \   \
 *      4   5   6
 */
public class TreeTraversalNoRecursion {

    /**
     * print left, root, right
     *
     * 4, 2, 5, 1, 3, 6
     * @param root
     */
    public static void inOrder(TreeNode root) {

    }

    public static int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Si el elemento no se encuentra en la lista
        return -1;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode right = new TreeNode(3, null, new TreeNode(6));
        TreeNode root = new TreeNode(1, left, right);
        inOrder(root);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        System.out.println(binarySearch(list, 6));
    }
}
