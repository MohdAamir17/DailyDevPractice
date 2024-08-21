package com.learninglog.Aug.Day21;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
       int [] nums = {1,1,2};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println("find All duplicate in array : " + duplicates);

    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> integerList = new ArrayList<>();
        Integer max = Arrays.stream(nums).boxed().max(Integer::compareTo).get();
        boolean [] number = new boolean[max+1];
        for (int i = 0; i < nums.length; i++) {
            if (number[nums[i]] == true){
                integerList.add(nums[i]);
            } else {
                number[nums[i]] = true;
            }
        }
        return integerList;
    }
}
