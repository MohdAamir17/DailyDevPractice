package com.learninglog.Aug.Day23;




public class MoveZeroes {
    public static void main(String[] args) {
       int [] nums = {0,1,0,3,12};
       moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int n=nums.length;
        int i=0;
        for(int num:nums){
            if(num!=0){
                nums[i++]=num;
            }
        }
        while(i<n){
            nums[i++]=0;
        }
    }
}
