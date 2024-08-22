package com.learninglog.Aug.Day22;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int [] nums = {3,4,-1,1};
        int i = firstMissingPositive(nums);
        System.out.println(i);
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;  // If the array is empty, the first missing positive is 1
        }

        // Find the maximum number in the array
        Integer maxNumber = Arrays.stream(nums).boxed().max(Integer::compareTo).orElse(0);

        // If the maximum number is less than 1, the smallest positive integer missing is 1
        if (maxNumber < 1) {
            return 1;
        }

        // Create a set to store positive numbers in the array
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                integerSet.add(nums[i]);
            }
        }

        // Find the first missing positive number
        for (int j = 1; j <= maxNumber; j++) {
            if (!integerSet.contains(j)) {
                return j;
            }
        }

        // If all numbers from 1 to maxNumber are present, the missing number is maxNumber + 1
        return maxNumber + 1;
    }

    /*public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int min = 1;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] > min)
                break;
            if(nums[i] == min)
                min = min+1;
        }
        return min;
    }*/

    /*public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Mark numbers (nums[i]) out of range and negative numbers as n + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // Step 2: Use the index as a hash to record the presence of numbers
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        // Step 3: The first positive index indicates the missing smallest positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        // If no positive number is found, return n + 1
        return n + 1;
    }*/
}
