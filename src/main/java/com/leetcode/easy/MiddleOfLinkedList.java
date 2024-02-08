package com.leetcode.easy;

public class MiddleOfLinkedList {

    /**
     * Given a non-empty singly linked list with head node head, return a middle node of linked list
     *
     * Example 1:
     *  Input: [1, 2, 3, 4, 5]
     *  Output: Node 3
     *
     *
     * @param node
     * @return
     */
    public static ListNode findMiddleNode(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        // node.next.next.next.next.next = new ListNode(6);
        System.out.println(findMiddleNode(node));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

}
