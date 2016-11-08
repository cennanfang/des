package com.redbird.wehelp.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author cennanfang
 */
@Controller
@RequestMapping("/")
public class AdminController {

	@RequestMapping("/admin")  
	@RequiresPermissions(value="/admin")
    public String admin() {  
        System.out.println("admin");  
        return "admin";  
    }  
}
