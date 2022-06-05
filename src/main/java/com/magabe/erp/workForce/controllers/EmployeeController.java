package com.magabe.erp.workForce.controllers;

import com.magabe.erp.workForce.entities.Employee;
import com.magabe.erp.workForce.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //register Employee
    @GetMapping("/work-force/register-employee")
    public String findAll(Model model) {
        System.out.print("Employees:" + employeeService.findAllEmployees().toString());
        model.addAttribute("employee", employeeService.findAllEmployees());
        return "/workForce/employees";
    }

    //Add new Employee
    @GetMapping("/work-force/employeeAdd")
    public String addEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "/workForce/employeeAdd";
    }
    //Add/save Employee
    @PostMapping("/work-force/register-employee")
    public String addNew(Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/work-force/register-employee";
    }
}
