package com.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This is the controller for home page
 * @author Tayab Hussain
 * @version 1.0
 */

@Controller
public class WelcomeController {

	
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	/**
	 * Routes the to the welcome page on launch of application
	 */
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}

}