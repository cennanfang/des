package com.redbird.wehelp.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author cennanfang
 *
 */
@RequestMapping("/msg")
public class MessageController {

	@RequestMapping("/loadMsgs")
	public String loadMessages() {
		return "message";
	}
}
