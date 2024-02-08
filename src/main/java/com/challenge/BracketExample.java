package com.challenge;

import java.util.*;
import java.util.stream.Collectors;

public class BracketExample {

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        final String YES = "YES";
        final String NO = "NO";

        for (int x=0; x<s.length(); x++) {
            char c = s.charAt(x);
            if (c == '{' || c == '[' || c == '(') {
                stack.add(c);
            } else {
                if (stack.isEmpty())
                    return NO;
                char last = stack.pop();
                switch(c) {

                    case '}':
                        if (last != '{') {
                            return NO;
                        }
                    break;
                    case ']':
                        if (last != '[') {
                            return NO;
                        }
                    break;
                    case ')':
                        if (last != '(') {
                            return NO;
                        }
                    break;
                }
            }
        }
        if (stack.isEmpty())
            return YES;
        return NO;
    }

    public static void main(String[] args) {
        //System.out.println(BracketExample.isBalanced("{[()]}"));
        //System.out.println(BracketExample.isBalanced("{[(])}"));
        //System.out.println(BracketExample.isBalanced("{{[[(())]]}}"));

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.add(5);
        queue.add(3);
        queue.add(1);
        queue.add(2);
        queue.add(5);
        queue.add(5);
        System.out.println(queue);
        System.out.println("element " + queue.poll());
        System.out.println(queue);
        System.out.println("element " + queue.poll());
        System.out.println(queue);
        System.out.println("element " + queue.poll());
        System.out.println(queue);
        System.out.println("element " + queue.poll());
        System.out.println(queue);
        System.out.println("element " + queue.poll());
        System.out.println(queue);
        System.out.println("element " + queue.poll());
        System.out.println(queue);

        Deque<Integer> dequeue = new ArrayDeque<>();
        dequeue.add(5);
        dequeue.add(3);
        dequeue.add(2);
        dequeue.add(6);

        System.out.println("dequeue");
        System.out.println(dequeue);
        System.out.println(dequeue.getFirst());
        System.out.println(dequeue.pollFirst());
        System.out.println(dequeue);
        System.out.println(dequeue.pollLast());
        System.out.println(dequeue);

        System.out.println("sorted map - treemap");
        //Map<Integer, Integer> treeMap = new TreeMap<>();
        SortedMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(5, 2);
        treeMap.put(3, 3);
        treeMap.put(1, 6);
        treeMap.put(6, 9);
        treeMap.put(8, 0);
        treeMap.put(9, 0);
        System.out.println(treeMap);
    }
}
