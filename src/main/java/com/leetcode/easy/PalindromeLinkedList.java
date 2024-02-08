package com.leetcode.easy;

public class PalindromeLinkedList {

    /**
     * Given a singly linked list, determine if it is a palindrome
     *
     * Example 1:
     *
     * Input: 1->2
     * Output: false
     *
     * Example 2:
     *
     * Input: 1->2->2->1
     * Output: true
     *
     * Follow up: Could you do it in O(n) time and O(1) space?
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ReverseLinkedListChallenge.ListNode head) {
        ReverseLinkedListChallenge.ListNode slow = head;
        ReverseLinkedListChallenge.ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ReverseLinkedListChallenge.ListNode firstHalf = head;
        ReverseLinkedListChallenge.ListNode secondHalf = reverseList(slow);

        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val)
                return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    private static ReverseLinkedListChallenge.ListNode reverseList(ReverseLinkedListChallenge.ListNode head) {
        ReverseLinkedListChallenge.ListNode current = head;
        ReverseLinkedListChallenge.ListNode prev = null;
        ReverseLinkedListChallenge.ListNode next; // not null because it's redundant

        // 1 2 3
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // at this point prev is pointing to the first element
        return prev;
    }

    public static void main(String[] args) {
        ReverseLinkedListChallenge.ListNode head = new ReverseLinkedListChallenge.ListNode(1);
        head.next = new ReverseLinkedListChallenge.ListNode(2);
        head.next.next = new ReverseLinkedListChallenge.ListNode(3);
        head.next.next.next = new ReverseLinkedListChallenge.ListNode(2);
        head.next.next.next.next = new ReverseLinkedListChallenge.ListNode(1);

        System.out.println(isPalindrome(head));


    }

}
