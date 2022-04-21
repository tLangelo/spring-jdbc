package com.example.demo.controllers;

import com.example.demo.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import static java.lang.Integer.parseInt;

@Controller
public class EmployeeController {
    private final EmployeeService es = new EmployeeService();

    @GetMapping("/employees")
    public String allEmployees(Model m){
        m.addAttribute("employees", es.getAllEmployees());

        return "employees";
    }

    @GetMapping("/findemployee")
    public String singleEmployee(@RequestParam int id, Model m){
        String[] empToShow = es.getEmpByID(id).toString().split(";");
        m.addAttribute("employeeToShow",empToShow);

        return "employees";
    }

    @GetMapping("/register")
    public String register(){
        return "registerEmployee";
    }

    @PostMapping("/registeremp")
    public String registerEmp(WebRequest params){
        int id = parseInt(params.getParameter("id"));
        String name = params.getParameter("name");
        String job = params.getParameter("job");
        int manager = parseInt(params.getParameter("manager"));
        String date = params.getParameter("date");
        int salary = parseInt(params.getParameter("salary"));
        int commission = parseInt(params.getParameter("commission"));
        int deptNum = parseInt(params.getParameter("deptNum"));


        if(es.addEmployee(id,name,job,manager,date,salary,commission,deptNum))
            return "redirect:/";


        return "registerEmployee";
    }

}
