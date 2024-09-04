package com.learninglog.September.Day4;

public class CountWaysToN_thStair {
    public static void main(String[] args) {
       int n = 6;
        int totalNumberOfWays = nthStair(n);
        System.out.println("Count ways to N'th Stair : " + totalNumberOfWays);
    }

    public static int nthStair(int n) {
        // Code here
     /*if (n == 1 || n == 2) {
         return n;
     } else {
         return nthStair(n-1) + nthStair(n-2);
     }*/

        // The number of ways will be floor(n / 2) + 1
        int i = (n / 2) + 1;
        return i;
    }
}
