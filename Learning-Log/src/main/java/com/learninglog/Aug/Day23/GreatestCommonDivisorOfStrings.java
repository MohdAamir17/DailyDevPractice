package com.learninglog.Aug.Day23;

public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        String str1 = "ABCABC", str2 = "ABC";
        String string = gcdOfStrings(str1, str2);
        System.out.println(string);
    }

    public static String gcdOfStrings(String str1, String str2) {
       if (!(str1+str2).equals(str2+str1))
           return "";

        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
