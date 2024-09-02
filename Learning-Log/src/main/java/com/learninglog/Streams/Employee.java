package com.learninglog.Streams;

public class Employee {
    private String empName;

    private String empDepartment;

    private Long empSalary;

    private Long age;

    public Employee(String empName, String empDepartment, Long empSalary,Long age) {
        this.empName = empName;
        this.empDepartment = empDepartment;
        this.empSalary = empSalary;
        this.age = age;
    }


    /**
     * get field
     *
     * @return empName
     */
    public String getEmpName() {
        return this.empName;
    }

    /**
     * set field
     *
     * @param empName
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * get field
     *
     * @return empDepartment
     */
    public String getEmpDepartment() {
        return this.empDepartment;
    }

    /**
     * set field
     *
     * @param empDepartment
     */
    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }

    /**
     * get field
     *
     * @return empSalary
     */
    public Long getEmpSalary() {
        return this.empSalary;
    }

    /**
     * set field
     *
     * @param empSalary
     */
    public void setEmpSalary(Long empSalary) {
        this.empSalary = empSalary;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
