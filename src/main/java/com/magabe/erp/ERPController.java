package com.magabe.erp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ERPController {

    @GetMapping("/_layout")
    public String goHome(){
        return "/_layout";
    }
}