package com.learninglog.Aug.Day27;

public class ReverseWordsInAString {
    public static void main(String[] args) {
       String s = "the sky is blue";
        String string = reverseWords(s);
        System.out.println("Reverse Words in a String :"+ string);
    }

    public static String reverseWords(String s) {
        // Trim leading and trailing spaces, and reduce multiple spaces to single
        s = s.trim().replaceAll("\\s+", " ");

        // Convert to character array
        char[] chars = s.toCharArray();
        int n = chars.length;

        // Reverse the entire string
        reverse(chars, 0, n - 1);

        // Reverse each word
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            }
        }
        // Reverse the last word
        reverse(chars, start, n - 1);

        // Convert back to string
        return new String(chars);
    }

    // Helper method to reverse a portion of the array
    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
