package com.learninglog.Streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByDemo {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee("John Doe", "Marketing", 75000L,25L),
                new Employee("Jane Smith", "HR", 65000L,35L),
                new Employee("Alice Johnson", "Finance", 80000L,40L),
                new Employee("Bob Brown", "Marketing", 70000L,35L),
                new Employee("Eve","Finance",90000L,40L)
        );

        Map<String, List<Employee>> employeeByDepartment =
                employees.stream().collect(Collectors.groupingBy(Employee::getEmpDepartment));

        employeeByDepartment.forEach((department,employeeList)->{
            System.out.println("Department : "+ department);
            employeeList.forEach(System.out::println);
            employeeList.forEach(x->System.out.println(x.getEmpDepartment() + " " + x.getEmpName()));
        });

        Map<Boolean, List<Employee>> partitionBySalary =
                employees.stream().collect(Collectors.partitioningBy(employee -> employee.getEmpSalary() >= 70000L &&
                        employee.getEmpSalary() <= 80000L));

        System.out.println("Employee with salary > 70000L and < 8000L");
        partitionBySalary.get(true).forEach(emp -> System.out.println(emp.getEmpSalary() + "  Employee Name : " + emp.getEmpName()));


        Map<Long, List<String>> employeeNamesByAge = employees.stream()
                .collect(Collectors.groupingBy(
                                Employee::getAge,
                                Collectors.mapping(Employee::getEmpName, Collectors.toList())
                        )
                );

        Map<Long,List<String>> employeeAges = employees.stream().
                collect(Collectors.groupingBy(Employee::getAge,Collectors.
                        mapping(Employee::getEmpName,Collectors.toList())));


       List<Item> itemList =  Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orange", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );


       Map<String,Integer> result = itemList.stream().collect(Collectors.groupingBy(Item::getName,Collectors.summingInt(Item::getQty)));
       result.forEach((name,qty) ->{
           System.out.println("Name : " + name);
           System.out.println("Qty : " + qty);
       });

    }
}





































/*System.out.println("Employee with salary > 70000L and < 80000L");
        partitionBySalary.get(true).forEach(emp -> System.out.println(emp.getEmpName() + " with salary: " + emp.getEmpSalary()));


        Map<Integer,List<Integer>> integerListMap = new HashMap<>();
        integerListMap.put(1, Arrays.asList(10, 20, 30));
        integerListMap.put(2, Arrays.asList(40, 50, 60));
        integerListMap.put(3, Arrays.asList(70, 80, 90));
        integerListMap.put(4, Arrays.asList(100, 110, 120));

        integerListMap.forEach((key,value) ->{
            System.out.println("Keys : " + key);
            value.forEach(System.out::println);
        });

        for (Map.Entry<Integer,List<Integer>> entry : integerListMap.entrySet()) {
            System.out.println("Entry Keys : " + entry.getKey());
            System.out.println("Values : " + entry.getValue());
            entry.getValue().forEach(System.out::println);
        }*/
