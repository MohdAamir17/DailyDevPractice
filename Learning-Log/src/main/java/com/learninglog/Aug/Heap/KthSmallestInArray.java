package com.learninglog.Aug.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestInArray {
    public static void main(String[] args) {
       int arr[] = {7, 10, 4, 3, 20, 15};
       int  k = 3;
        int i = kthSmallest(arr, k);
        System.out.println("Kth Smallest : " + i);
    }

    public static int kthSmallest(int[] arr, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            // Add elements to the max heap until the heap contains k elements
            if (maxHeap.size() < k) {
                maxHeap.add(arr[i]);
            } else {
                // If the heap is full and the current element is smaller than the root
                // (which is the largest in the max heap), replace the root with the current element
                if (arr[i] < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.add(arr[i]);
                }
            }
        }

        // The root of the heap is the k-th smallest element
        return maxHeap.peek();
        }

}
