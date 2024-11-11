package com.dbd.dev.Practice.Java8Concept;

@FunctionalInterface
public interface B extends A{
    // Default method specific to B
    default void m3() {
        System.out.println("Default method m3 in B");
    }

    // Static method specific to B
    static void m4() {
        System.out.println("Static method m4 in B");
    }

    static void m5(){
        System.out.println("Static method m5 in B");
    }
}
