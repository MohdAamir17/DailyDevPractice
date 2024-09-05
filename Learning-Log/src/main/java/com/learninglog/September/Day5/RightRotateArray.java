package com.learninglog.September.Day5;

public class RightRotateArray {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};
        int  k = 3;
        rotate(nums,k);
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Array element : " + nums[i]);
        }
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0){
            return;
        }

        k = k%n;

        reverseArray(nums,0,n-1);

        reverseArray(nums,0,k-1);

        reverseArray(nums,k,n-1);

    }

    public static void reverseArray(int[] arr , int start , int end) {
        while (start<= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
