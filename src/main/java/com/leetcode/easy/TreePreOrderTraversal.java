package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class TreePreOrderTraversal {

    /**
     * Pre order prints root, then all left, finally all right
     *
     *            1
     *          / | \
     *         3  2  4
     *        / \
     *       5   6
     * Returns [1, 3, 5, 6, 2, 4]
     * @param root
     * @return
     */
    public static List<Integer> preOrderTraversal(Node root) {
        List<Integer> results = new ArrayList<>();
        preOrderRecursive(results, root);
        return results;
    }

    public static void preOrderRecursive(List<Integer> results, Node root) {
        if (root == null)
            return;
        if (root.children != null) {
            results.add(root.val);
            for (Node node : root.children) {
                preOrderRecursive(results, node);
            }
        } else {
            results.add(root.val);
        }
    }


    public static void main(String[] args) {
        List<Node> childrenOf3 = List.of(new Node(5, null), new Node(6, null));
        Node root = new Node(1, List.of(new Node(3, childrenOf3), new Node(2, null), new Node(4, null)));
        List<Integer> postOrder = preOrderTraversal(root);
        System.out.println(postOrder);
    }

    static class Node {
        int val;
        List<Node> children;

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", children=" + children +
                    '}';
        }
    }
}
