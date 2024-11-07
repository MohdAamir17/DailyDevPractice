package com.dbd.dev.Practice;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {7,8,9,11,12};
        int i = firstMissingPositive(nums);
        System.out.println("First Missing Positive : " + i);
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }

        //Set contains all positive integer
        Set<Integer> positiveIntegerSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                positiveIntegerSet.add(nums[i]);
            }
        }

        for (int j = 1; j <= positiveIntegerSet.size() + 1 ; j++) {
            if (!positiveIntegerSet.contains(j)){
                return j;
            }
        }

        return 1;

    }
}
