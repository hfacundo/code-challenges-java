package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class TreePostOrderTraversal {

    /**
     * Post order prints all left, then all right, finally root
     *
     *           1
     *         / | \
     *        3  2  4
     *       / \
     *      5   6
     * Returns [5, 6, 3, 2, 4, 1]
     * @param root
     * @return
     */
    public static List<Integer> postOrder(Node root) {
        List<Integer> results = new ArrayList<>();
        recursivePostOrder(results, root);
        return results;
    }

    public static void recursivePostOrder(List<Integer> results, Node root) {
        if (root == null)
            return;

        if (root.children != null) {
            for (Node node : root.children) {
                recursivePostOrder(results, node);
            }
        }
        results.add(root.val);

        // left
        // right
        // finally root
    }

    public static void main(String[] args) {
        List<Node> childrenOf3 = List.of(new Node(5, null), new Node(6, null));
        Node root = new Node(1, List.of(new Node(3, childrenOf3), new Node(2, null), new Node(4, null)));
        List<Integer> postOrder = postOrder(root);
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
