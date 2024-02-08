package com.leetcode.medium;

import com.leetcode.medium.model.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Example:
 *  Input: 1 -> 2 -> 3 -> 4 -> 5 -> null, m=2, n=4
 *  Output: 1 -> 4 -> 3 -> 2 -> 5 -> null
 */
public class ReverseLinkedListII {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Avanzar prev al nodo justo antes de la posición m
        for (int i = 1; i < m; i++) {
            prev = prev.next;
        }

        // 1 -> 2 -> 3 -> 4 -> 5 -> null
        // Nodo inicial para revertir
        ListNode start = prev.next;
        ListNode curr = start.next;

        // Revertir los nodos entre m y n
        for (int i = m; i < n; i++) {
            start.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = start.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);

        int m = 2;
        int n = 4;
        ListNode result = reverseBetween(node1, m, n);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
