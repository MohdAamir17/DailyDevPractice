package com.learninglog.Aug.Day28;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindTheMissingNumber {
    public static void main(String[] args) {
        int [] array = {1, 2, 4, 5, 6};
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < args.length; i++) {
            integerSet.add(array[i]);
        }
        int a = 0;
        for (int j = 1; j < integerSet.size()+1; j++) {
            if (!integerSet.contains(j)){
                a = j;
            }
        }
        System.out.println(a);
    }
}
