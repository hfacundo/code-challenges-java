package com.leetcode.easy;

public class MergeTwoSortedLists {

    /**
     * Merge two sorted linked lists and return it as a new list. The new list should be made by
     * splicing together the nodes of the first two lists
     *
     * Example:
     *  Input: 1->2->4, 1->3->4
     *  Output: 1->1->2->3->4->4
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLinkedLists(ListNode l1, ListNode l2) {
        ListNode mergedListNode;

        if (l1.val > l2.val) {
            mergedListNode = new ListNode(l2.val);
            l2 = l2.next;
        } else {
            mergedListNode = new ListNode(l1.val);
            l1 = l1.next;
        }
        ListNode head = mergedListNode;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    mergedListNode.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    mergedListNode.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                mergedListNode = mergedListNode.next;
            } else if (l1 != null) {
                mergedListNode.next = new ListNode(l1.val);
                l1 = l1.next;
                mergedListNode = mergedListNode.next;
            } else { // l2 != null
                mergedListNode.next = new ListNode(l2.val);
                l2 = l2.next;
                mergedListNode = mergedListNode.next;
            }
        }

        mergedListNode = head;
        return mergedListNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        System.out.println(l1);
        System.out.println(l2);

        ListNode merged = mergeTwoLinkedLists(l1, l2);
        System.out.println(merged);
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
                    ", next=" + next +
                    '}';
        }
    }
}
