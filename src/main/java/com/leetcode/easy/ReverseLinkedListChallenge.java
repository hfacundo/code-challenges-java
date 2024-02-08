package com.leetcode.easy;

import java.util.Stack;

public class ReverseLinkedListChallenge {

    public static ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.add(head);
            head = head.next;
        }

        ListNode result = stack.pop();
        ListNode temp = result;
        while (!stack.isEmpty()) {
            ListNode n = stack.pop();
            result.next = n;
            result = result.next;
        }
        result.next = null;
        result = temp;
        return result;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = null;
        ListNode reversed = reverseList(node);

        while (reversed != null) {
            System.out.println(reversed.val);
            reversed = reversed.next;
        }

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
