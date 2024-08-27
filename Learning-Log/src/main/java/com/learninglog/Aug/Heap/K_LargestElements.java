package com.learninglog.Aug.Heap;

import java.util.PriorityQueue;

public class K_LargestElements {
    public static void main(String[] args) {
       int arr[] = {12, 5, 787, 1, 23}, k = 2;
        int i = kLargest(arr, k);
        System.out.println("K Largest Elements : " + i);

        int[] ints = kLargestOne(arr, 5, k);
        for (int num : ints) {
            System.out.print(num + " ");
        }
    }

     public static int kLargest(int[] arr, int k) {
         PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
         for (int i = 0; i < arr.length; i++) {
             priorityQueue.add(arr[i]);
             if (priorityQueue.size() > k) {
                 priorityQueue.poll();
             }
         }
         return priorityQueue.peek();
    }

    public static int[] kLargestOne(int[] arr, int n, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        // Convert the priority queue to an array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll(); // Get the elements in ascending order
        }

        // Reverse the array to get the k largest elements in descending order
        reverseArray(result);

        return result;
    }

    // Helper method to reverse an array
    private static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
