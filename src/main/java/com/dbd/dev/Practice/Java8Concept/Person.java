package com.dbd.dev.Practice.Java8Concept;

import java.util.List;

public final class Person {
    private final String name;
    private final int age;
    private final List<String> hobbies;
    public Person(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        // Step 3: Ensure deep copy for mutable objects
        this.hobbies = List.copyOf(hobbies); // or Collections.unmodifiableList(hobbies);
    }

    // Step 4: Provide getter methods (no setters)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getHobbies() {
        return hobbies; // Returning an immutable copy to protect against modification
    }

    // Optional: Override toString(), hashCode(), equals() if necessary
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", hobbies=" + hobbies + "}";
    }
}
