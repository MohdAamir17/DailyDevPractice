package com.learninglog.Aug.Day21;



import jakarta.persistence.criteria.CriteriaBuilder;

import java.io.FileOutputStream;
import java.util.*;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
       String s = "abab";
       String p = "ab";

        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();

        // Populate the map with sorted substrings and their starting indices
        for (int i = 0; i <= s.length() - p.length(); i++) {
            String substring = s.substring(i, i + p.length());
            String sortedSubstring = sortString(substring);
            map.put(i, sortedSubstring);
        }

        // Sort the pattern string p for comparison
        String sortedP = sortString(p);

        // Iterate over the map entries
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer index = entry.getKey();
            String sortedSubstring = entry.getValue();

            // Check if the sorted substring matches the sorted pattern string
            if (sortedSubstring.equals(sortedP)) {
                res.add(index);
            }
        }

        return res;
    }


    public static String sortString(String str) {
        // Convert string to character array
        char[] charArray = str.toCharArray();

        // Sort the character array
        Arrays.sort(charArray);

        // Convert back to string
        return new String(charArray);
    }
    
}
