package com.learninglog.September.Day5;

import java.util.Arrays;

public class MissingInArrayTwo {
    public static void main(String[] args) {
        int n = 5;
        int arr[] = {1,2,3,5};
        int missingInNumber = missingNumber(n, arr);
        System.out.println("Missing in array : " + missingInNumber);
    }

    public static int missingNumber(int n, int[] arr) {
        // Sort the array
        Arrays.sort(arr);

        // Iterate over the array to find the first missing positive integer
        for (int i = 0; i < arr.length; i++) {
            // If the element doesn't match its expected value (1-based), return the missing number
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        // If all numbers from 1 to maxNumber are present, return maxNumber + 1
        return arr.length + 1;
    }
}
