package com.dbd.dev.Practice.ArrayConcept;

public class ShuffleTheArray {
    public static void main(String[] args) {

       int [] nums = {2,5,1,3,4,7};
       int n = 3;
       ShuffleTheArray shuffleTheArray = new ShuffleTheArray();
        int[] shuffle = shuffleTheArray.shuffle(nums, n);
        for (Integer e : shuffle) {
            System.out.println(shuffle[e]);
        }
    }

    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        int [] ints = new int[len];
        if (len <= 0) {
            return ints;
        }
        int right = 0;
        int mid = len/2;
        int evenIdx = 0;
        int oddIdx =  1;
        while (mid < len) {
            ints[evenIdx] = nums[right];
            ints[oddIdx] = nums[mid];
            right++;
            mid++;
            evenIdx = evenIdx + 2;
            oddIdx = oddIdx + 2;
        }
        return ints;
    }
}
