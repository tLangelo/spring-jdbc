package com.example.demo.controllers;

import com.example.demo.services.DepartmentService;
import com.example.demo.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import static java.lang.Integer.parseInt;

@Controller
public class DepartmentController {
    private final DepartmentService ds = new DepartmentService();
    private final EmployeeService es = new EmployeeService();

    @GetMapping("/departments")
    public String allDepartments(Model model){
        model.addAttribute("departments", ds.getAllDepartments());

        return "departments";
    }

    @GetMapping("/departments/{depName}")
    public String department(@PathVariable("depName") String name, Model m){
        m.addAttribute("selectedDep", name);
        m.addAttribute("employees",es.getEmployeesByDep(parseInt(name)));


        return "department";
    }


}
