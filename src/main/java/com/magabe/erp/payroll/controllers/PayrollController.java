package com.magabe.erp.payroll.controllers;


import com.magabe.erp.payroll.entities.Payroll;
import com.magabe.erp.payroll.services.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PayrollController {

    @Autowired
    PayrollService payrollService;

    @GetMapping("/payroll/register_payroll")
    public String PayrollRegisterForm(Model model){
        model.addAttribute("payroll", payrollService.findAllPayroll());
//        model.addAttribute("payroll", new Payroll());

        return "payroll/payrollE";
    }
    @GetMapping("/payroll/payroll_add")
    public String addEmployeeToPayroll(Model model){
        model.addAttribute("payroll", new Payroll());
        return "/payroll/payrollAdd";
    }

    //Add/save Employee
    @PostMapping("/payroll/register_payroll")
    public String addNew(Payroll payroll) {
        payrollService.SavePayroll(payroll);
        return "redirect:/payroll/register_payroll";
    }

//    @GetMapping("payroll/payslip")
//    public String PayrollGeneratePaySlip(Model model){
//        model.addAttribute("payroll", payrollService.findAllPayroll());
//        return "payroll/payslip";
//    }

    @GetMapping("payroll/register_payroll/remuneration/{id}")
    public String showRemuneration(@PathVariable( value = "id") long id, Model model) {

        // get employee from the service
        Payroll payroll = payrollService.getCandidateById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("payroll", payroll);
        return "payroll/remuneration";
    }

//    @GetMapping("/payroll/register_payroll/Edit/{id}")
//    public String showFormForEdit(@PathVariable( value = "id") long id, Model model) {
//
//        // get employee from the service
//        Payroll payroll = payrollService.getCandidateById(id);
//
//        // set employee as a model attribute to pre-populate the form
//        model.addAttribute("payroll", payroll);
//        return "payroll/payrollEditForm";
//    }

//    @GetMapping("payroll/register_payroll/delete/{id}")
//    public String showFormForDeleteCandidate(@PathVariable( value = "id") long id, Model model) {
//
//        // get employee from the service
//        payrollService.deleteCandidateByid(id);
//
//        // set employee as a model attribute to pre-populate the form
////        model.addAttribute("candidate", candidate);
//        return "redirect:/payroll/payslip";
//    }

//    @GetMapping("payroll/register_payroll/download/{id}")
//    public String showFormForDownload(@PathVariable( value = "id") long id, Model model) {
//        // get employee from the service
//        Payroll payroll = payrollService.getCandidateById(id);
//        // set employee as a model attribute to pre-populate the form
//        model.addAttribute("payroll", payroll);
//        return "payroll/payslip";
//    }


}
