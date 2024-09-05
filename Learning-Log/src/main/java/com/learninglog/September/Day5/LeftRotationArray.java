package com.learninglog.September.Day5;

import java.util.Arrays;
import java.util.List;

public class LeftRotationArray {
    public static void main(String[] args) {
        int d = 2;
        List<Integer> arr = Arrays.asList(1,2,3,4,5);
        List<Integer> integerList1 = rotateLeft(d, arr);
        System.out.println("Rotated Array : " + integerList1);
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        int n = arr.size();
        if (n ==0){
            return arr;
        }

        d = d % n;

        reverse(arr, 0, d - 1);

        //step 2:
        reverse(arr, d, n - 1);

        //step 3:
        reverse(arr, 0, n - 1);


        return arr;

    }

    static void reverse( List<Integer> arr, int start, int end) {
        while (start <= end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
    }

}


