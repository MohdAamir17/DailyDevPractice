package com.learninglog.September.Day3;

import java.util.HashMap;
import java.util.Map;

public class SumOfDigitsOfStringAfterConvert {
    public static void main(String[] args) {
        String s = "iiii";
        int k = 1;
        int lucky = getLucky(s, k);
        System.out.println("Sum of Digits of String After Convert : " + lucky);
    }

    public static int getLucky(String s, int k) {
        StringBuilder stringBuilder  = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int i1 = s.charAt(i) - 'a' + 1;
            stringBuilder .append(i1);
        }
        // Perform the transformation `k` times
        while (k > 0) {
            int temp = 0;
            for (char x : stringBuilder.toString().toCharArray()) {
                temp += x - '0';  // Sum the digits of the current number
            }
            stringBuilder = new StringBuilder(String.valueOf(temp));  // Convert the sum back to a string
            k--;
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}
