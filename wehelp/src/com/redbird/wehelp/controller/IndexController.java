package com.redbird.wehelp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author c
 */
@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping("index")  
    public String index() {  
        System.out.println("µÇÂ¼³É¹¦");  
        return "home";  
    }  
}
