package com.learninglog.Aug.Day23;

public class MergeStringsAlternately {
    public static void main(String[] args) {
       String word1 = "ab", word2 = "pqrs";
        String string = mergeAlternately(word1, word2);
        System.out.println(string);
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();

        // Merging characters alternately
        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                stringBuilder.append(word1.charAt(i++));
            }
            if (j < word2.length()) {
                stringBuilder.append(word2.charAt(j++));
            }
        }

        return stringBuilder.toString();
    }
}
