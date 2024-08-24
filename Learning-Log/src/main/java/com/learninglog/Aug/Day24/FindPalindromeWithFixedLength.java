package com.learninglog.Aug.Day24;

import java.util.HashMap;
import java.util.Map;

public class FindPalindromeWithFixedLength {
    public static void main(String[] args) {
        int[] queries = {2, 201429812, 8, 520498110, 492711727, 339882032, 462074369, 9, 7, 6};
        int intLength = 1;
        long[] results = kthPalindrome(queries, intLength);
        for (long result : results) {
            System.out.print(result + " ");
        }
    }

    public static long[] kthPalindrome(int[] queries, int intLength) {
        Map<Long, Long> map = new HashMap<>();
        long[] array = new long[queries.length];

        // Calculate smallest and largest palindromes for the given length
        long smallest = smallestNumber(intLength);
        long largest = largestNumber(intLength);

        long totalPalindromes = 0;
        for (long i = smallest; i <= largest; i++) {
            if (isPalindrome(String.valueOf(i))) {
                map.put(++totalPalindromes, i);
            }
        }

        // Fill results based on queries
        for (int i = 0; i < queries.length; i++) {
            long query = queries[i];
            array[i] = map.getOrDefault(query, -1L);
        }

        return array;
    }

    public static int smallestNumber(int intLength) {
        // 1 followed by (intLength - 1) zeros
        return (int) Math.pow(10, intLength - 1);
    }

    public static int largestNumber(int intLength) {
        // intLength 9s
        return (int) Math.pow(10, intLength) - 1;
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /*
    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] array = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long query = queries[i];
            array[i] = getKthPalindrome(query, intLength);
        }
        return array;
    }

    private static long getKthPalindrome(long k, int length) {
        if (length == 1) {
            return k <= 9 ? k : -1;
        }

        long halfLength = (length + 1) / 2;
        long start = (long) Math.pow(10, halfLength - 1);
        long end = (long) Math.pow(10, halfLength);

        if (k < 1 || k > end - start) {
            return -1;
        }

        long halfPalindrome = start + k - 1;
        String halfStr = Long.toString(halfPalindrome);
        StringBuilder fullPalindrome = new StringBuilder(halfStr);
        if (length % 2 == 0) {
            fullPalindrome.append(new StringBuilder(halfStr).reverse());
        } else {
            fullPalindrome.append(new StringBuilder(halfStr).reverse().substring(1));
        }

        return Long.parseLong(fullPalindrome.toString());
    }
     */
}
