package com.learninglog.Aug.Day22;

public class NumberComplement {
    public static void main(String[] args) {
       int  num = 5;
        int complement = findComplement(num);
        System.out.println(complement);

    }

    public static int findComplement(int num) {
        int i = 0;
        int j = 0;

        while (i < num)
        {
            i += Math.pow(2, j);
            j++;
        }

        return i-num;
    }
}
