package com.dbd.dev.Practice.Java8Concept;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

//Q. Find the longest string in a list of strings using Java streams:
public class FindTheLongestString {
    public static void main(String[] args) {
        List<String> strings = Arrays
                .asList("apple", "banana", "cherry", "date", "grapefruit");

       Optional<String> maxLengthOfString =  strings.stream().max(Comparator.comparingInt(String::length));
       if (maxLengthOfString.isEmpty()) {
           System.out.println("Ohh No there are no string object present.");
       } else {
           System.out.println("Max Length String : " + maxLengthOfString.get());
       }
    }
}
