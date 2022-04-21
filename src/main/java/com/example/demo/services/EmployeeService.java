package com.example.demo.services;

import com.example.demo.models.Employee;
import com.example.demo.repositories.CRUDInterface;
import com.example.demo.repositories.EmployeeRepository;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class EmployeeService {
    private CRUDInterface<Employee> empRepo = new EmployeeRepository();

    public boolean addEmployee(int id, String name, String job, int manager, String date, int salary, int commission, int deptNum){
        return empRepo.create(new Employee(id, name, job, manager, date, salary, commission, deptNum));
    }

    public ArrayList<Employee> getAllEmployees(){
        return (ArrayList<Employee>) empRepo.getAllEntities();
    }

    public Employee getEmpByID(int id){
        return empRepo.getSingleEntityById(id);
    }

    public ArrayList<Employee> getEmployeesByDep(int id){
        return (ArrayList<Employee>) empRepo.getEntitiesByIDs(id);
    }

}
