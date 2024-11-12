package com.dbd.dev.Practice.ObjectOrientedProgrammin;

public class CasesOfMain {
    public static void main(String[] args) {
        System.out.println("Hello from main 1");
    }

    static {
        System.out.println("Static block executing...");
        // This will call main() from the static block, which can lead to recursion
        CasesOfMain.main(new String[]{});
    }
}
