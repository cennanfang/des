package com.redbird.wehelp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author c
 */
@Controller
@RequestMapping("/")
public class AdminController {

	@RequestMapping("admin")  
    public String admin() {  
        System.out.println("½øÈëadmin");  
        return "admin";  
    }  
}
