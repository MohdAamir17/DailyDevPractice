package com.learninglog.September.Day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.swap;

public class Sort0s1sAnd2s {
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 2, 0};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arrayList.add(arr[i]);
        }
        sort012(arrayList);
        System.out.println("Array List : " + arrayList);
    }

    public static void sort012(ArrayList<Integer> arr) {
        int low = 0;
        int mid = 0;
        int high = arr.size() - 1;

        while (mid <= high) {
            switch (arr.get(mid)) {
                case 0:
                    // Swap arr[low] and arr[mid]
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;

                case 1:
                    // Just move mid forward
                    mid++;
                    break;

                case 2:
                    // Swap arr[mid] and arr[high]
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }

    // Helper function to swap elements in the ArrayList
    private static void swap (ArrayList<Integer> arr,int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
/*
To sort an array that contains only 0s, 1s, and 2s, you can use Dutch National Flag Algorithm. This algorithm sorts the array in linear time (O(n)) and with constant space (O(1)), making it very efficient.

Here’s how it works:

You maintain three pointers:
low (for 0s),
mid (for 1s),
high (for 2s).
The idea is to move elements to the correct section of the array as you encounter them.

Explanation:
Pointers Initialization:

low starts at the beginning of the array and tracks the position where the next 0 should go.
mid also starts at the beginning and traverses the array.
high starts at the end of the array and tracks where the next 2 should go.
Sorting Process:

If the current element (arr[mid]) is 0, swap it with the element at low and increment both low and mid.
If the element is 1, just move mid forward.
If the element is 2, swap it with the element at high and decrement high.
Termination: The loop continues until mid crosses high, ensuring that all elements are sorted.

This method ensures an optimal solution with a time complexity of O(n) and space complexity of O(1).


 */
