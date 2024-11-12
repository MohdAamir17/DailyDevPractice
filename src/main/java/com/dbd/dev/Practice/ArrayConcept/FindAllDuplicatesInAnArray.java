package com.dbd.dev.Practice.ArrayConcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
       int [] nums = {4,3,2,7,8,2,3,1};
       FindAllDuplicatesInAnArray findAllDuplicatesInAnArray = new FindAllDuplicatesInAnArray();
        List<Integer> duplicates = findAllDuplicatesInAnArray.findDuplicates(nums);
        System.out.println(duplicates);
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                duplicates.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }

        return duplicates;
    }
}
