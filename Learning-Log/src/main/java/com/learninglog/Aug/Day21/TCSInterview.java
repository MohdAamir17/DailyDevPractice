package com.learninglog.Aug.Day21;

public class TCSInterview {
    public static void main(String[] args) {
        int a  = 4;
        int b = 9;
        int theCubesSum = findTheCubesSum(a, b);
        System.out.println("Sum of cubes number : " + theCubesSum);
    }

    public static int findTheCubesSum(int a , int b){
        int sum = 0;
        for (int i = a; i <= b ; i++) {
            int cubeOfNumber = i * i * i;
            sum  += cubeOfNumber;
        }
        return sum;
    }
}
