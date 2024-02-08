package com.challenge;

import java.util.ArrayList;
import java.util.List;

public class Fix45 {

    public int[] fix45(int[] nums) {

        List<Integer> posOf5 = new ArrayList<>();
        List<Integer> replace = new ArrayList<>();

        for (int x=0; x<nums.length; x++) {
            if (nums[x] == 4 && nums[x+1] != 5) {
                replace.add(x+1);
            } else if (nums[x] == 5) {
                if (x-1 < 0 || (x-1 >= 0 && nums[x-1] != 4)) {
                    posOf5.add(x);
                }
            }
        }

        for (int x=0; x<replace.size(); x++) {
            int pos = replace.get(x);
            int num = nums[pos];
            nums[pos] = 5;
            nums[posOf5.get(x)] = num;
        }

        return nums;
    }

    public static void main(String[] args) {
        Fix45 fix = new Fix45();
        int[] array = {1, 4, 1, 5};
        System.out.println(fix.fix45(array));
    }

}
