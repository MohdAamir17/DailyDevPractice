package com.dbd.dev.Practice.ArrayConcept;

public class ArraysExample {
    public static void main(String[] args) {
       /* int [] array = {1,3,4,5,6,7};
        isReverse(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }*/

        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};
        int[] res = removeDuplicate(nums);
        System.out.print("Array without duplicates: ");
        for (int num : res) {
            System.out.print(num + " ");
        }


    }

    static int[] removeDuplicate(int [] arr) {
        if (arr.length == 0) {
            return new int[0];
        }

        int uniqueIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[uniqueIndex]) {
                uniqueIndex++;
                arr[uniqueIndex] = arr[i];
            }
        }

        // Create a new array with only unique elements
        int[] result = new int[uniqueIndex + 1];
        System.arraycopy(arr, 0, result, 0, uniqueIndex + 1);

        return result;
    }

    static void isReverse(int [] arr) {
       int length = arr.length;
       int start = 0;
       int end = length -1;
       while (start < end) {
           int temp = arr[start];
           arr[start] = arr[end];
           arr[end] = temp;
           start++;
           end--;
       }
    }
}
