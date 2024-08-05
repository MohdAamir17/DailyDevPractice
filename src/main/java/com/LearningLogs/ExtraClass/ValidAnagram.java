package com.LearningLogs.ExtraClass;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
      String  s = "anagram";
      String t = "nagaram";
        boolean anagram = isAnagram(s, t);
        if (anagram)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        String lowerCase_S = s.toLowerCase();
        String lowerCase_T =t.toLowerCase();

        char[] charArray_S = lowerCase_S.toCharArray();
        char[] charArray_T = lowerCase_T.toCharArray();

        Arrays.sort(charArray_S);
        Arrays.sort(charArray_T);

        String string_S = new String(charArray_S);
        String string_T = new String(charArray_T);

        if(string_S.equals(string_T))
            return true;

        return false;
    }
}
