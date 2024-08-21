package com.learninglog.Aug.Day21;

import java.util.*;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidboaoo";
        boolean b = checkInclusion(s1, s2);
        if (b)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < s2.length()-s1.length(); i++) {
            String substring = s2.substring(i, i + s1.length());
            String string = sortString(substring);
            if (map.containsKey(string)) {
                Integer i1 = map.get(string);
                Integer i2 = i1 + 1;
                map.put(string,i2);
            }else {
                map.put(string,i);
            }
        }
        if (map.containsKey(s1))
            return true;
        else
            return false;
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
