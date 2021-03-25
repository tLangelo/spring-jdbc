package com.example.demo.controllers;

import com.example.demo.models.Department;
import com.example.demo.repositories.DepartmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class DepartmentController {
    private DepartmentRepository departmentRepo = new DepartmentRepository();

    @GetMapping("/departments")
    public String allDepartments(Model objectThatTransportsData){
        ArrayList<Department> allDepartments = departmentRepo.getAllDepartments();
        objectThatTransportsData.addAttribute("departments",allDepartments);
        return "departments";
    }
}
