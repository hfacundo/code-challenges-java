package com.leetcode.easy;

public class StringToLowerCase {

    public static String toLowerCase(String str) {
        StringBuilder s = new StringBuilder();

        for (int x=0; x<str.length(); x++) {
            if (Character.isLetter(str.charAt(x)) && Character.isUpperCase(str.charAt(x))) {
                s.append((char)(str.charAt(x) + 32));
            } else {
                s.append(str.charAt(x));
            }
        }

        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase("Hello"));
        System.out.println(toLowerCase("This Is A String"));
        System.out.println(toLowerCase("Hi dude :)"));
    }

}
