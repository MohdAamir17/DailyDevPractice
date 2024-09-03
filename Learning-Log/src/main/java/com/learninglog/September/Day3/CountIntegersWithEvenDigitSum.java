package com.learninglog.September.Day3;

public class CountIntegersWithEvenDigitSum {
    public static void main(String[] args) {
        int num = 30;
        int checkNumber = countEven(num);
        System.out.println("Count Integers With Even Digit Sum : " + checkNumber);
    }

    public static int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            boolean b = checkIsEven(i);
            if (b) {
                count++;
            }
        }
        return count;
    }

    public static boolean checkIsEven(int num) {
        int sum = 0;
        int mod;
        while (num > 0) {
            mod = num % 10;
            sum = sum + mod;
            num = num / 10;
        }
        return sum % 2 == 0;
    }
}
