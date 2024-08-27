package com.learninglog.Aug.Day27;

import java.util.HashMap;
import java.util.Map;

public class StringCompression {
    public static void main(String[] args) {
      char [] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int compress = compress(chars);
        System.out.println("String Compression : " + compress);
    }

    public static int compress(char[] chars) {
        int index = 0;  // Pointer to insert compressed character
        int i = 0;      // Pointer to iterate over chars

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count the occurrence of the current character
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            // Place the character
            chars[index++] = currentChar;

            // Place the count (only if greater than 1)
            if (count > 1) {
                String countStr = Integer.toString(count);
                for (char c : countStr.toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}
