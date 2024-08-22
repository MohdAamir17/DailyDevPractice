package com.learninglog.Aug.Day22;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.*;

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
       int [] nums = {4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int ans []=new int[nums.length+1];
        List<Integer> a=new ArrayList<Integer> ();
        for(int i=0;i<nums.length;i++){
            ans[nums[i]]=1;
        }
        for(int j=1;j<ans.length;j++){
            if(ans[j]==0){
                a.add(j);
            }

        }
        return a;
    }
}
