package com.dbd.dev.Practice.Java8Concept;

//Q. Check if a list of integers contains a prime number using Java streams:

import java.util.Arrays;
import java.util.List;

public class CheckTheListContainsPrimeNumber {
    public static void main(String[] args) {
        CheckTheListContainsPrimeNumber checkTheListContainsPrimeNumber = new CheckTheListContainsPrimeNumber();
        checkTheListContainsPrimeNumber.printPrime();

    }

    private void printPrime() {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 11, 12, 13, 14, 15);
        boolean containsPrime = numbers.stream()
                .anyMatch(this::isPrime);
        System.out.println("List contains a prime number: " + containsPrime);

    }

   boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n) ; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
