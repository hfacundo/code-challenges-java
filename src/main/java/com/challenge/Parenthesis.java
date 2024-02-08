package com.challenge;

public class Parenthesis {

    public int cnt;
    // Below function recursively generates strings with balanced parenthesis.
    public void generate (String result, int open, int close, int pairs) {

        // If the sum of the opening and closing parenthesis is same as the number of pairs,
        // the we have got a valid string.
        if(open + close == 2 * pairs) {
            cnt++;
            System.out.println( "String " + cnt + " : " + result);
        } else {
            if (open < pairs) {
                generate (result + "(", open + 1, close, pairs);
            }
            // A closing parenthesis should always come after an opening parenthesis and should always
            // be less than the count of the opening parenthesis already present in the result string
            // before it gets appended.
            if (close < open) {
                generate (result + ")", open, close + 1, pairs);
            }
        }
    }

    public static void main (String [] args) {

        Parenthesis p = new Parenthesis();
        int n = 3;
        for (int pairs=0; pairs<=n; pairs++) {
            String result = "";
            p.cnt = 0;
            System.out.println ("\nString(s) with balanced parenthesis of length " + 2 * pairs);
            p.generate (result, 0, 0, pairs);
            System.out.println ("Total Strings : " + p.cnt);
        }
    }
}
