package com.learninglog.Aug.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Remove_Kth_Element_From_Min_Heap {
    public static void main(String[] args) {
        int [] array = {3,2,4,1,5};
        int k = 3;
        int[] ints = removeKthElement(array, k);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

   /* public static int[] removeKthElement(int [] arr , int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Add all elements to the PriorityQueue (min-heap)
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }

        // Remove the k-th smallest element (1-based index)
        int count = 1;
        int i = 0;// Start counting from 1
        while (i < priorityQueue.size()) {
            if (i == k) {
                priorityQueue.poll();
            }
            priorityQueue.poll();  // Remove elements until we reach the k-th
            count++;
        }

        priorityQueue.poll();  // Remove the k-th element itself

        // Convert the remaining elements in the priorityQueue to an array
        int[] result = new int[priorityQueue.size()];
        int index = 0;

        while (!priorityQueue.isEmpty()) {
            result[index++] = priorityQueue.poll();
        }

        return result;
    }*/

    public static int[] removeKthElement(int[] arr, int k) {
        // Check if k is within the array bounds
        if (k < 1 || k > arr.length) {
            throw new IllegalArgumentException("k is out of bounds");
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Add all elements except the k-th element to the PriorityQueue (min-heap)
        for (int i = 0; i < arr.length; i++) {
            if (i != k - 1) {  // Convert 1-based index `k` to 0-based index
                priorityQueue.add(arr[i]);
            }
        }

        // Convert the remaining elements in the priorityQueue to an array
        int[] result = new int[priorityQueue.size()];
        int index = 0;

        while (!priorityQueue.isEmpty()) {
            result[index++] = priorityQueue.poll();
        }

        return result;
    }
}
