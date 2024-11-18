package com.dbd.dev.Practice.ArrayConcept;

public class BuildArrayFromPermutation {
    public static void main(String[] args) {
       int [] nums = {0,2,1,5,3,4};
        int[] ints = buildArray(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println("Array Element : " + ints[i]);
        }
    }

    static int[] buildArray(int[] nums) {

        int [] permutationArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            permutationArray[i] = nums[nums[i]];
        }

        return permutationArray;

    }
}
