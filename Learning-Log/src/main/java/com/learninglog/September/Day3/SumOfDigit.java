package com.learninglog.September.Day3;

public class SumOfDigit {
    public static void main(String[] args) {
        int num = 12;
        int sum=0,m;
        while (num > 0) {
            m=num%10;
            sum=sum+m;
            num=num/10;
        }
        System.out.println("Sum of digit : " + sum);
    }
}
