package com.learninglog.Aug.Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

import static org.hibernate.internal.util.collections.CollectionHelper.arrayList;

public class NearlySorted {
    public static void main(String[] args) {
       int n = 7, k = 3;
       int arr[] = {6,5,3,2,8,10,9};
        ArrayList<Integer> integerArrayList = nearlySorted(arr, n, k);
        System.out.println("Nearly Sorted : " + integerArrayList);
    }

   public static ArrayList<Integer> nearlySorted(int arr[], int num, int k)
    {
      ArrayList<Integer> arrayList = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
           priorityQueue.add(arr[i]);
           if (priorityQueue.size() > k){
               arrayList.add(priorityQueue.poll());
           }
        }
        // Add remaining elements in the heap to the result
        while (!priorityQueue.isEmpty()) {
            arrayList.add(priorityQueue.poll());
        }

        return arrayList;
    }
}
