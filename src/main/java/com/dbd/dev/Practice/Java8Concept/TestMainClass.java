package com.dbd.dev.Practice.Java8Concept;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


public class TestMainClass {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Jack", 21, "IT", 10000, "Noida", true),
                new Employee("Emma", 25, "HR", 12000, "Delhi", false),
                new Employee("John", 30, "Finance", 15000, "Mumbai", true),
                new Employee("Sophia", 28, "Marketing", 13000, "Pune", false),
                new Employee("Ava", 22, "Sales", 11000, "Bangalore", true),
                new Employee("Liam", 32, "IT", 14000, "Hyderabad", true),
                new Employee("Oliver", 26, "Operations", 11500, "Chennai", false),
                new Employee("Lucas", 29, "HR", 16000, "Delhi", true),
                new Employee("Mia", 24, "Finance", 15500, "Mumbai", false)
        );

        Employee employeeWithMaxSalary = employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).get();
        Employee employeeWithSecondMaxSalary = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).
                reversed()).skip(1).findFirst().get();


        System.out.println("Employee with max salary " + employeeWithMaxSalary);
        System.out.println("Employee with second max salary " + employeeWithSecondMaxSalary);
        //Find employee department wise and apply sorting on the age
        List<Employee> employeeListByDepartment = employees.stream().filter(node -> node.getDepartment().equals("IT")).
                sorted(Comparator.comparingInt(Employee::getAge)).toList();
        // Sort Employees by Salary in Descending Order:
        List<Employee> employeeListBySalary = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).toList();

        //Calculate Average Salary by Department:
        Map<String,Double> employeeSalaryMap = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment ,
                Collectors.averagingDouble(Employee::getSalary)));

        //Grouping by location
        Map<String,List<Employee>> locationWiseMap = employees.stream().collect(Collectors.groupingBy(Employee::getCity));

        // 2. Filter by department "IT", sort by age, and collect to Map with name as key and employee as value
        Map<String, Employee> employeeMapByName = employees.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase("IT"))
                .sorted(Comparator.comparingInt(Employee::getAge))
                .collect(Collectors.toMap(Employee::getName, Function.identity(), (existing, replacement) -> existing));

        // Group by department and find the employee with the highest salary in each department

        Map<String, Optional<Employee>> highestSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));

        // Print the result
        highestSalaryByDepartment.forEach((department, employeeOpt) ->
                System.out.println("Department: " + department + ", Employee: " + employeeOpt.orElse(null)));

        // Example: print employees
        employeeListBySalary.forEach(System.out::println);
    }
}
/*
A Stream supports several operations and these operations are divided into intermediate and terminal operations.

The distinction between this operations is that an intermediate operation is lazy while a terminal operation is not.
When you invoke an intermediate operation on a stream, the operation is not executed immediately.
It is executed only when a terminal operation is invoked on that stream.
In a way, an intermediate operation is memorized and is recalled as soon as a terminal operation is invoked.
You can chain multiple intermediate operations and none of them will do anything until you invoke a terminal operation.
At that time, all of the intermediate operations that you invoked earlier will be invoked along with the terminal operation.

All intermediate operations return Stream (can be chained), while terminal operations don't. Intermediate Operations are:

filter(Predicate<T>)
map(Function<T>)
flatMap(Function<T>)
sorted(Comparator<T>)
peek(Consumer<T>)
distinct()
limit(long n)
skip(long n)


Terminal operations produces a non-stream (cannot be chained) result such as primitive value, a collection or no value at all.

Terminal Operations are:

forEach
forEachOrdered
toArray
reduce
collect
min
max
count
anyMatch
allMatch
noneMatch
findFirst
findAny
Last 5 are short-circuiting terminal operations.
 */
