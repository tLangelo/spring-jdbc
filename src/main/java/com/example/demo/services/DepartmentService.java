package com.example.demo.services;

import com.example.demo.models.Department;
import com.example.demo.repositories.CRUDInterface;
import com.example.demo.repositories.DepartmentRepository;


import java.util.ArrayList;


public class DepartmentService {
    private CRUDInterface<Department> depRepo = new DepartmentRepository();

    public ArrayList<Department> getAllDepartments(){
        return (ArrayList<Department>) depRepo.getAllEntities();
    }
}
