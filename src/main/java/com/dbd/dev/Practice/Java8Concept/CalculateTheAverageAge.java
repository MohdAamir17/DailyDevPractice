package com.dbd.dev.Practice.Java8Concept;

import java.util.Arrays;
import java.util.List;

//Q. Calculate the average age of a list of Person objects using Java streams:
public class CalculateTheAverageAge {
    public static void main(String[] args) {
        List<Employee> employeesList = Arrays.asList(
                new Employee("Alice", 25,"IT",11000,"Noida",true),
                new Employee("Jhon",35,"MCA",12000,"Delhi",true)
        );

       double averageAge =  employeesList.stream().mapToInt(Employee::getAge).average().orElse(0);
        System.out.println("Average Age of Employee : " + averageAge);
    }
}
