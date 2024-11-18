package com.dbd.dev.Practice.ArrayConcept;

public class KeepMultiplyingFoundValuesByTwo {
    public static void main(String[] args) {
       int [] nums = {8,19,4,2,15,3};
       int  original = 2;
       KeepMultiplyingFoundValuesByTwo keepMultiplyingFoundValuesByTwo = new KeepMultiplyingFoundValuesByTwo();
        int finalValue = keepMultiplyingFoundValuesByTwo.findFinalValue(nums, original);
        System.out.println("Final Result : " + finalValue);
    }

    public int findFinalValue(int[] nums, int original) {
        int updatedOriginal = original;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == updatedOriginal) {
                updatedOriginal = 2 * updatedOriginal;
                i = -1;
            }

        }
        return original;
    }
}
