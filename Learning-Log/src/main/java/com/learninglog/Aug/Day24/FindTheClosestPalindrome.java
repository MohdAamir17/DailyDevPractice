package com.learninglog.Aug.Day24;



public class FindTheClosestPalindrome {
    public static void main(String[] args) {
        String n = "807045053224792883";
        String string = nearestPalindromic(n);
        System.out.println("Find the Closest Palindrome : " + string);
    }

    public static String nearestPalindromic(String n) {
        if (n.equals("0")) {
            return "0";
        }

        String smallerPalindrome = findSmallerPalindrome(n);
        String largerPalindrome = findLargerPalindrome(n);

        // Compare both smaller and larger palindromes with the original number
        if (difference(n, smallerPalindrome) <= difference(largerPalindrome, n)) {
            return smallerPalindrome;
        } else {
            return largerPalindrome;
        }
    }

    private static String findSmallerPalindrome(String n) {
        long num = Long.parseLong(n);
        for (long i = 1; i < num; i++) {
            long candidate = num - i;
            if (isPalindrome(String.valueOf(candidate))) {
                return String.valueOf(candidate);
            }
        }
        return "0";
    }

    private static String findLargerPalindrome(String n) {
        long num = Long.parseLong(n);
        for (long i = 1; i < Long.MAX_VALUE; i++) {
            long candidate = num + i;
            if (isPalindrome(String.valueOf(candidate))) {
                return String.valueOf(candidate);
            }
        }
        return n;
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static long difference(String a, String b) {
        return Math.abs(Long.parseLong(a) - Long.parseLong(b));
    }



}






/*    public static void main(String[] args) {
        String n = "1";
        String string = nearestPalindromic(n);
        System.out.println("Find the Closest Palindrome : " + string);
    }

    public static String nearestPalindromic(String n) {
        int number = Integer.parseInt(n);
        int p = 0;
        int i = 1 ;
        while (i <= number) {
            int lessNumber = number - i;
            boolean isPalandrome =  isPaindrome(lessNumber);
            if (isPalandrome){
                p = lessNumber;
                break;
            }
            i++;
        }
        return String.valueOf(p);
    }

    private static boolean isPaindrome(int lessNumber) {
        int reverseNumber = reverseNumber(lessNumber);
        if (reverseNumber == lessNumber){
            return true;
        }
        else
            return false;
    }

    public static int reverseNumber(int number){
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return reversed;
    }*/

