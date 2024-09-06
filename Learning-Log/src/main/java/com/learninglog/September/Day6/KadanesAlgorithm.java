package com.learninglog.September.Day6;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, -2, 5};
        int maxSubArraySum = maxSubarraySum(arr);
        System.out.println("Max sub array sum : " + maxSubArraySum);
    }

    public static int maxSubarraySum(int[] arr) {
        int sum = 0;
        int maxElement = arr[0];

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            maxElement = Math.max(maxElement,sum);

            if (sum <0)
                sum = 0;
        }

        return maxElement;
    }
}

/*
Kadane's algorithm is an efficient method for solving the "Maximum Subarray Problem," which seeks to find the contiguous subarray (within a one-dimensional array of numbers) that has the largest sum. Here are the steps of Kadane's algorithm:

Steps of Kadane’s Algorithm:
Initialize Variables:

Create two variables:
max_current to track the maximum sum of the subarray ending at the current position.
max_global to track the overall maximum sum encountered so far.
Set both to the first element of the array, i.e., max_current = max_global = arr[0].
Iterate Through the Array:

Start from the second element (index 1) and iterate through the array.
At each step, update max_current as the maximum between:
The current element (arr[i]).
The sum of max_current + arr[i] (which adds the current element to the running sum).
Update Global Maximum:

After updating max_current, compare it with max_global.
If max_current is greater than max_global, update max_global.
Continue Until End of Array:

Repeat steps 2 and 3 for each element of the array.
Return the Global Maximum:

Once the iteration is complete, max_global will contain the maximum sum of the contiguous subarray.
 */
