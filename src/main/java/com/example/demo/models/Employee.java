package com.example.demo.models;

import java.time.LocalDate;

public class Employee {
    private int EID;
    private String name;
    private int age;
    //extra vars x)
    private String job;
    private int manager;
    private LocalDate hireDate;
    private int salary;
    private int commission;
    private int departmentNumber;

    //constructor for first db
    public Employee(int EID, String name, int age) {
        this.EID = EID;
        this.name = name;
        this.age = age;
    }

    //constructor for second db


    public Employee(int EID, String name, String job, int manager, String hireDate, int salary, int commission, int departmentNumber) {
        this.EID = EID;
        this.name = name;
        this.job = job;
        this.manager = manager;
        this.hireDate = LocalDate.parse(hireDate);
        this.salary = salary;
        this.commission = commission;
        this.departmentNumber = departmentNumber;
    }

    public int getEID() {
        return EID;
    }

    public void setEID(int EID) {
        this.EID = EID;
    }

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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public String getHireDate() {
        return hireDate.toString();
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    @Override
    public String toString() {
        return  EID +
                ";" + name +
                ";" + job +
                ";" + manager +
                ";" + hireDate +
                ";" + salary +
                ";" + commission +
                ";" + departmentNumber;
    }
}
