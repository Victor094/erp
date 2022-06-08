package com.magabe.erp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ERPController {

    @GetMapping("/index")
    public String goHome(){
        return "index";
    }
    @GetMapping("security")
    public String securiryHome(){
        return "security/index";
    }
    @GetMapping("/work-force")
    public String WorkForceHome(){
        return "WorkForce/index";
    }

}
