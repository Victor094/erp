package com.magabe.erp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ERPController {

    @GetMapping("/index")
    public String goHome(){
        return "index";
    }
    @GetMapping("/work-force")
    public String goWorkForce(){
        return "workForce/index";
    }
    @GetMapping("/payroll")
    public String payroll(){
        return "payroll/index";
    }
    @GetMapping("/security")
    public String securiryHome(){
        return "security/index";
    }

    @GetMapping("/recruitment")
    public String recruitment(){
        return "recruitment/index";
    }

}
