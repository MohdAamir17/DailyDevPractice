package com.dbd.dev.Practice.ObjectOrientedProgrammin;

public class JavaPolymorphism  implements Item,Mind {
    public static void main(String[] args) {
        JavaPolymorphism javaPolymorphism = new JavaPolymorphism();
        javaPolymorphism.sound();
    }

    /**
     * Overrides the `sound` method to satisfy both `Item` and `Mind` interfaces.
     */
    @Override
    public void sound() {
        System.out.println("Overriding sound method for both Item and Mind interfaces.");
    }

    @Override
    public void sound(int[] array) {

    }

}
