package com.techelevator;

import java.time.LocalDate;

public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private double salary;
    private Department department;
    private LocalDate hireDate;
    private static final double startingSalary = 60000.00;

    public Employee(long employeeId, String firstName, String lastName, String email, Department department, LocalDate hireDate) {
        this.salary = startingSalary;
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.hireDate = hireDate;
    }

    public Employee() {

    }

    public String getFullName() {
        return this.lastName + ", " + this.firstName;
    }

    public void raiseSalary(double percent) {
        this.salary = (this.salary * (percent / 100)) + this.salary;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}
