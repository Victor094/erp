package com.magabe.erp.workForce.controllers;

import com.magabe.erp.workForce.entities.Employee;
import com.magabe.erp.workForce.entities.Leave;
import com.magabe.erp.workForce.services.EmployeeService;
import com.magabe.erp.workForce.services.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Controller
public class LeaveController {

    @Autowired
    LeaveService leaveService;

    //register Employee
    @GetMapping("/work-force/apply-leave")
    public String findAll(Model model) {
        model.addAttribute("leave", leaveService.findAllEmployeeLeaves());
        return "/workForce/leaves";
    }

    //Add new Employee
    @GetMapping("/work-force/leave-add")
    public String addLeave(Model model){
        model.addAttribute("leave", new Leave());
        return "/workForce/leaveAdd";
    }
    //Add/save Employee
    @PostMapping("/work-force/apply-leave")
    public String addNew(Leave leave) {
        leaveService.saveLeave(leave);
        return "redirect:/work-force/apply-leave";
    }
    //Edit Leave
    @GetMapping("/work-force/apply-leave/{op}/{id}")
    public String editLeave(@PathVariable Integer id, @PathVariable String op, Model model){
        Leave leave = leaveService.findLeaveByID(id).get();
        System.out.print(leave.getAppliedDate());
        model.addAttribute("leave", leave);
        return "/workForce/leave"+ op;
    }



}
