package com.dbd.dev.Practice.Java8Concept;

import java.util.Objects;

public class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;
    private String city;
    private boolean isPermanent;

    // Constructors
    public Employee(String name, int age, String department, double salary, String city, boolean isPermanent) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.city = city;
        this.isPermanent = isPermanent;
    }

    public Employee(Employee employee) {
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isPermanent() {
        return isPermanent;
    }

    public void setPermanent(boolean isPermanent) {
        this.isPermanent = isPermanent;
    }

    // toString
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", city='" + city + '\'' +
                ", isPermanent=" + isPermanent +
                '}';
    }

    // hashCode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Double.compare(employee.salary, salary) == 0 &&
                isPermanent == employee.isPermanent &&
                Objects.equals(name, employee.name) &&
                Objects.equals(department, employee.department) &&
                Objects.equals(city, employee.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, department, salary, city, isPermanent);
    }
}
