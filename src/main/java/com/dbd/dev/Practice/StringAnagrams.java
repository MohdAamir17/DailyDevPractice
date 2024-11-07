package com.dbd.dev.Practice;

import java.util.*;

public class StringAnagrams {
    public static void main(String[] args) {
        //check string anagram
        String str1 = "mind";
        String str2 = "mtsl";
        //check reverse string
        String str3 = "aamir";
        //boolean b = areAnagram(str1, str2);

        /*boolean b = isAnagram(str1,str2);
        String reverse = reverse(str3);
        if (b) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

        System.out.println("Reverse String : " + reverse);*/

        String []  strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println("List of anagram group :" + lists);

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupAnagramMap = new HashMap<>();

        for (String str : strs) {
            // Create a character frequency array as the key
            int[] charCount = new int[26];
            for (char c : str.toCharArray()) {
                charCount[c - 'a']++;
            }

            // Convert character frequency array to a string key
            StringBuilder keyBuilder = new StringBuilder();
            for (int count : charCount) {
                keyBuilder.append('#').append(count);
            }
            String key = keyBuilder.toString();

            // Group anagrams using the character frequency key
            groupAnagramMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(groupAnagramMap.values());
    }

    /*static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupedAnagrams = new ArrayList<>();
        if (strs.length < 0) {
            return groupedAnagrams;
        }
        Map<String, List<String>> groupAnagramMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if (groupAnagramMap.containsKey(sortedStr)) {
                List<String> stringList = groupAnagramMap.get(sortedStr);
                stringList.add(str);
                groupAnagramMap.put(sortedStr, stringList);
            } else {
                groupAnagramMap.put(sortedStr, new ArrayList<>(List.of(str)));
            }
        }
        groupedAnagrams.addAll(groupAnagramMap.values());
        return groupedAnagrams;

    }*/

    /*public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupedAnagrams = new ArrayList<>();
        Map<String, List<String>> groupAnagramMap = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            groupAnagramMap.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }

        groupedAnagrams.addAll(groupAnagramMap.values());
        return groupedAnagrams;
    }*/


    static String reverse(String str) {
        if (str.isBlank() || str.isEmpty()) {
            return "";
        }
        char[] charArray = str.toCharArray();
        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {
            // Swap characters at start and end positions
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;

            start++;
            end--;
        }

        return new String(charArray);

    }
    static boolean isAnagram(String str1 , String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        String lowerCase1 = str1.toLowerCase();
        String lowerCase2 = str2.toLowerCase();

        char[] charArray = lowerCase1.toCharArray();
        char[] charArrayTwo = lowerCase2.toCharArray();

        Arrays.sort(charArray);
        Arrays.sort(charArrayTwo);

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != charArrayTwo[i]) {
                return false;
            }
        }
        return true;
    }

    static boolean areAnagram(String str1 , String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character,Integer> charHashMap = new HashMap<>();

        String lowerCase = str1.toLowerCase();
        String lowerCase1 = str2.toLowerCase();

        for (int i = 0; i < lowerCase.length(); i++) {
            if (charHashMap.containsKey(lowerCase.charAt(i))) {
                Integer oldValue = charHashMap.get(lowerCase.charAt(i));
                Integer newValue = oldValue + 1;
                charHashMap.put(lowerCase.charAt(i),newValue);
            } else {
                charHashMap.put(lowerCase.charAt(i),1);
            }
        }

        for (int i = 0; i < lowerCase1.length(); i++) {
            if (charHashMap.containsKey(lowerCase1.charAt(i))) {
                Integer oldValue = charHashMap.get(lowerCase1.charAt(i));
                Integer newValue = oldValue + 1;
                charHashMap.put(lowerCase1.charAt(i),newValue);
            } else {
                charHashMap.put(lowerCase1.charAt(i),1);
            }
        }

        // Iterating over the map using Map.Entry
        for (Map.Entry<Character, Integer> entry : charHashMap.entrySet()) {
            Integer value = entry.getValue(); // Get the value (Integer)
            if (value > 2 || value < 2) {
                return false;
            }
        }
        return true;
    }
}
