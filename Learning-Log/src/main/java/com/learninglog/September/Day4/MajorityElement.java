package com.learninglog.September.Day4;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MajorityElement {
    public static void main(String[] args) {
        int arr[] = {3, 1, 3, 3, 2};
        int majorityElement = majorityElement(arr);
        System.out.println("Majority Element : " + majorityElement);
    }

    public static int majorityElement(int arr[]) {
        int length = arr.length;

        // Find the maximum element to determine the size of the frequency array
        int maxElement = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] > maxElement) {
                maxElement = arr[i];
            }
        }

        // Create and populate the frequency array
        int[] frequency = new int[maxElement + 1];
        for (int i = 0; i < length; i++) {
            frequency[arr[i]]++;
        }

        // Determine the majority element
        int majorityCount = length / 2;
        for (int i = 0; i <= maxElement; i++) {
            if (frequency[i] > majorityCount) {
                return i;
            }
        }

        // If no majority element exists, return -1
        return -1;
    }

    public static int majorityElementMethodTwo(int arr[] ) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = arr.length;

        // Count the frequency of each element
        for (int i = 0; i < n; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }

        int majorityCount = n / 2;
        int freqKey = -1; // Initialize to -1, assuming no majority element
        int freqValue = 0;

        // Find the element with the maximum frequency that is greater than majorityCount
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > majorityCount && entry.getValue() > freqValue) {
                freqKey = entry.getKey();
                freqValue = entry.getValue();
            }
        }

        return freqKey;
    }
}
