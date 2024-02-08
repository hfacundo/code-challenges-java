package com.challenge;

public class SwapInPairs {

    public CustomLinkedList swapPairs(CustomLinkedList head) {
        // Base case: if the linked list is empty or has only one node, no swapping needed
        if (head == null || head.next == null)
            return head;

        // Store the next node of the head
        CustomLinkedList nextNode = head.next;

        // Recursively call swapPairs for the remaining list after nextNode
        head.next = swapPairs(nextNode.next);

        // Make nextNode point to head
        nextNode.next = head;

        // Return the new head which is nextNode
        return nextNode;
    }

    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList(1,
                new CustomLinkedList(2,
                        new CustomLinkedList(3,
                                new CustomLinkedList(4,
                                        new CustomLinkedList(5,
                                                null)))));
        SwapInPairs s = new SwapInPairs();
        CustomLinkedList head = s.swapPairs(linkedList);

        while(head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}

class CustomLinkedList {
    public int value;
    public CustomLinkedList next;

    public CustomLinkedList(int value, CustomLinkedList next) {
        this.value = value;
        this.next = next;
    }
}
