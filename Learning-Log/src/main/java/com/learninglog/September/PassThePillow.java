package com.learninglog.September;

public class PassThePillow {
    public static void main(String[] args) {
        int n = 4, time = 5;
        int pillowHoldingStudent = passThePillow(n, time);
        System.out.println("Pass the Pillow : " + pillowHoldingStudent);
    }

    public static int passThePillow(int n, int time) {
        int totalRound = time / (n - 1);
        boolean rivDir = (totalRound % 2 != 0);
        if (rivDir) {
            return n - (time % (n - 1));
        } else {
            return time % (n - 1) + 1;
        }
    }
}





























