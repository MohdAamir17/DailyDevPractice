package com.dbd.dev.Practice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println("Length of Longest SubString : " + i);
    }

    public static int lengthOfLongestSubstring(String s) {
        int string_len = s.length();
        int right = 0;
        int left = 0;
        int len = 0 ;
        Map<Character,Integer> map = new HashMap<>();
        while(right< string_len){
            if(map.containsKey(s.charAt(right)))
                left = Math.max(map.get(s.charAt(right))+1,left);

            map.put(s.charAt(right),right);
            len= Math.max(len,right-left+1);
            right++;

        }
        return len;
    }
}
