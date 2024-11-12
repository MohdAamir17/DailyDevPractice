package com.dbd.dev.Practice.ObjectOrientedProgrammin;

public class Printer implements Item {
  public void sound() {
        System.out.println("Animal makes a sound");
    }

    @Override
    public void sound(int[] array) {
        int length = array.length;
        int right = 0;
        int left = length -1;
        while (right < left) {
            int temp = array[right];
            array[right] = array[left];
            array[left] = temp;
            right++;
            left--;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
