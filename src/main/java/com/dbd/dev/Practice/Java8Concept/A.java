package com.dbd.dev.Practice.Java8Concept;


@FunctionalInterface
public interface A {

    static void m6(){
        System.out.println("Static method m5 in B");
    }
    void m1();  // Single abstract method

    default void m2() {  // Default method with a different name
        // Default implementation
    }
}

