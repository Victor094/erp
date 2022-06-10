package com.magabe.erp.recruitment.controllers;

import com.magabe.erp.recruitment.entities.Candidate;
import com.magabe.erp.recruitment.services.CandidateServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CandidateController {

    @Autowired
    CandidateServiceImp employeeService;



//    @GetMapping("/*")
//    public  String viewHomepage(){
//        return  "index";
//    }
    @GetMapping("/recruitment/register-candidate")
    public String showLeaveForm(Model model){
        model.addAttribute("candidate", new Candidate());
        return "recruitment/register_candidate_form";
    }

    @PostMapping("/process_register")
    public String processRegister(Candidate candidate) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(candidate.getPassword());
//        candidate.setPassword(encodedPassword);
        employeeService.registerEmployee(candidate);
        //return "application_successful";
        return  "redirect:/recruitment";
    }

    @GetMapping("/recruitment/candidates")
    public String listCandidates(Model model) {
        List<Candidate> candidateList = employeeService.getAllCandidates();
        model.addAttribute("candidateList", candidateList);
        return "recruitment/list_of_candidates";
    }

    @GetMapping("/recruitment/candidates/edit/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {

        // get employee from the service
        Candidate candidate = employeeService.getCandidateById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("candidate", candidate);
        return "/recruitment/EditRateCandidates";
    }
    @GetMapping("/recruitment/candidates/delete/{id}")
    public String showFormForDeleteCandidate(@PathVariable( value = "id") long id, Model model) {

        // get employee from the service
        employeeService.deleteCandidateByid(id);

        // set employee as a model attribute to pre-populate the form
//        model.addAttribute("candidate", candidate);
        return "redirect:/recruitment/candidates";
    }

    @GetMapping("/recruitment/send-email-shortlisted")
    public String ShortListedCandidates(Model model) {
        List<Candidate> candidateList = employeeService.getHighlyRatedCandidates();
        model.addAttribute("candidateList", candidateList);
        return "recruitment/shortlisted_candidates";
    }



}