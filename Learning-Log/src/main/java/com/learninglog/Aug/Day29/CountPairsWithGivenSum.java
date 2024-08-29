package com.learninglog.Aug.Day29;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.*;

public class CountPairsWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int target = 6;
        int countOfPairs = countPairs(arr, target);
        System.out.println("Count pairs with given sum : " + countOfPairs);

        List<Integer> indexOfVariable =  findCountPairsIdx(arr, target);
        System.out.println("Index : " + indexOfVariable);

       List<int[]> pairsOfIndex =  findThePairsOfIndex(arr,target);
        System.out.println("Pairs of indices:");
        for (int[] pair : pairsOfIndex) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
    }



    /**
     * This method counts the number of pairs in the given array `arr` that sum up to the specified `target`.
     *
     * It uses a HashMap to store the frequency of each element in the array as it iterates through it.
     * For each element, it calculates the complement (i.e., `target - arr[i]`).
     * If the complement is found in the map, it means that a pair exists that sums to the target,
     * and the count is incremented by the number of occurrences of the complement.
     *
     * The function efficiently counts pairs in O(n) time complexity.
     *
     * @param arr The array of integers where pairs are to be counted.
     * @param target The target sum for which pairs are to be counted.
     * @return The total number of pairs that sum up to the target value.
     */
    public static int countPairs(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        }
        return count;
    }



    /**
     * This function finds the indices of pairs in the given array where the sum of the two elements equals the target value.
     * It returns a list of integers where each pair of consecutive integers represents the indices of such a pair.
     *
     * The function uses a HashMap to store the elements of the array along with their indices as it iterates through the array.
     * For each element, it calculates the complement (i.e., the difference between the target and the current element).
     * If the complement is found in the map, it means a pair exists that sums to the target, and the indices of the pair
     * are added to the result list.
     *
     * The function ensures that each valid pair is captured by storing the current element and its index in the map,
     * which allows it to correctly track and identify pairs even when duplicate values are present in the array.
     *
     * @param arr The array of integers to find pairs from.
     * @param target The target sum value that pairs in the array should equal.
     * @return A list of integers representing the indices of pairs that sum to the target value.
     */
    public static List<Integer> findCountPairsIdx(int[] arr, int target) {
        Map<Integer, Integer> freq = new HashMap<>();  // Map to store the value and its last seen index
        List<Integer> idx = new ArrayList<>();  // List to store the indices of the pairs

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            // If the complement exists in the map, add both indices to the list
            if (freq.containsKey(complement)) {
                idx.add(freq.get(complement));  // Index of the complement
                idx.add(i);  // Current index
            }
            // Update the map with the current element and its index
            freq.put(arr[i], i);
        }
        return idx;
    }


    /**
     * This function finds and returns the pairs of indices in the given array where the sum of the elements
     * at those indices equals the target value. It uses a HashMap to efficiently track and find these pairs.
     *
     * The function works by iterating over the array and, for each element, calculating its complement (i.e.,
     * the difference between the target value and the current element). It then checks if this complement
     * exists in the map, which would indicate that a pair exists whose sum equals the target.
     *
     * If such a complement is found, the function adds the indices of the complement and the current element
     * as a pair to the list of index pairs. Regardless of whether a complement is found, the function stores
     * the current element and its index in the map, allowing for efficient future lookups.
     *
     * The function returns a list of integer arrays, where each array contains two elements representing a
     * pair of indices that satisfy the condition.
     *
     * @param arr The array of integers in which to find pairs of indices.
     * @param target The target sum value for which pairs of indices should be found.
     * @return A list of integer arrays, where each array contains a pair of indices whose corresponding elements sum to the target value.
     */
    public static List<int[]> findThePairsOfIndex (int[] arr , int target) {
        // Map to store each element's value and its index
        Map<Integer, Integer> freq = new HashMap<>();
        // List to store the pairs of indices
        List<int[]> indexPairs = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            // If the complement exists in the map, add the pair of indices to the list
            if (freq.containsKey(complement)) {
                // Add the pair (index of complement, current index) to the list
                indexPairs.add(new int[]{freq.get(complement), i});
            }

            // Store the current element and its index in the map
            freq.put(arr[i], i);
        }

        return indexPairs;
    }
}
