package com.learninglog.September.Day3;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.ArrayList;
import java.util.List;

public class SeparateTheDigitsInAnArray {
    public static void main(String[] args) {
        int [] nums = {13,25,83,77};
        int[] separateElementArray = separateDigits(nums);
        for (int i = 0; i < separateElementArray.length ; i++) {
            System.out.println("Separate the Digits in an Array : " + separateElementArray);
        }
    }

    public static int[] separateDigits(int[] nums) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            String string = String.valueOf(num);
            char[] charArray = string.toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                integerList.add(Character.getNumericValue(charArray[j]));
            }
        }

        // Convert List<Integer> to int[] array
        int[] result = new int[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) {
            result[i] = integerList.get(i);
        }

        return result;
    }

   /* List<Integer> integerList = new ArrayList<>();

    for (int num : nums) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(0, num % 10);  // Extract the last digit and add it at the beginning
            num /= 10;  // Remove the last digit
        }
        integerList.addAll(digits);
    }

    // Convert List<Integer> to int[] array
    int[] result = new int[integerList.size()];
    for (int i = 0; i < integerList.size(); i++) {
        result[i] = integerList.get(i);
    }

    return result;*/


}
