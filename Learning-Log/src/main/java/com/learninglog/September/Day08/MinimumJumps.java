package com.learninglog.September.Day08;

public class MinimumJumps {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int miniJumps = minJumps(arr);
        System.out.println("Minimum jumps : " + miniJumps);

    }

    public static int minJumps(int[] arr) {
        int n = arr.length;

        // If the array length is 1, we're already at the end.
        if (n == 1) {
            return 0;
        }

        // If the first element is 0, we cannot move anywhere
        if (arr[0] == 0) {
            return -1;
        }

        // Initialize variables
        int jumps = 0;       // Number of jumps taken
        int currentEnd = 0;   // The farthest we can go with the current number of jumps
        int farthest = 0;     // The farthest point we can reach

        // Traverse the array except the last element
        for (int i = 0; i < n - 1; i++) {
            // Update the farthest we can reach
            farthest = Math.max(farthest, i + arr[i]);

            // If we reach the currentEnd, we need to make a jump
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // If the currentEnd is already beyond or at the last index, return the jump count
                if (currentEnd >= n - 1) {
                    return jumps;
                }
            }

            // If at any point, farthest is less than or equal to current position, we can't progress
            if (farthest <= i) {
                return -1;
            }
        }

        // If we exit the loop, it means we cannot reach the end
        return -1;
    }
}
