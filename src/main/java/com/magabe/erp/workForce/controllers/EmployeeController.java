package com.magabe.erp.workForce.controllers;

import com.magabe.erp.workForce.entities.Employee;
import com.magabe.erp.workForce.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //register Employee
    @GetMapping("/work-force/register-employee")
    public String findAll(Model model) {
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

    // Edit employee
//    @GetMapping("work-force/register-employee/edit/{id}")
//    public String findemployee(@PathVariable( value = "id") int id, Model model) {
//
//        // get employee from the service
//        Employee employee = employeeService.findEmployeeByID(id);
//        // set employee as a model attribute to pre-populate the form
//        model.addAttribute("employee", employee);
//        return "/workForce/employeeEdit";
//    }

//    @GetMapping("work-force/register-employee/delete/{id}")
//    public String showFormForDeleteemployee(@PathVariable( value = "id") long id) {
//
//        // get employee from the service
////        employeeService.;
//
//        // set employee as a model attribute to pre-populate the form
////        model.addAttribute("candidate", candidate);
////        return "redirect:/recruitment/candidates";
//        return "";
//    }

}
