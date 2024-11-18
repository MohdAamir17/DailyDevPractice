package com.dbd.dev.Practice.ArrayConcept;

public class CheckIfNAndItsDoubleExist {
    public static void main(String[] args) {
      int []  arr = {10,2,5,3};
      CheckIfNAndItsDoubleExist checkIfNAndItsDoubleExist = new CheckIfNAndItsDoubleExist();
        boolean b = checkIfNAndItsDoubleExist.checkIfExist(arr);
        if (b) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[i] == 2 * arr[j]) {
                    return true;
                } else if (arr[i] * 2 == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
