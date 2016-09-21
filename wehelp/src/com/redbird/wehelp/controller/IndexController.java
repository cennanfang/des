package com.redbird.wehelp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author c
 */
@Controller
@RequestMapping("/index")
public class IndexController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
}
