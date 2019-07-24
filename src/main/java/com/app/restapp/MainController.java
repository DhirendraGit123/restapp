package com.app.restapp;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	HashMap<String,String> user=new HashMap<String,String>();

	@GetMapping("/welcome")
	@ResponseBody
	public String sayWelcome() {
		return "Welcome to my app";
	}
	
	@GetMapping("/login")
	//@ResponseBody
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String registeruser() {
		return "register";
	}
	
	@PostMapping("/loginvalid")
	//@ResponseBody
	public String loginValid(@RequestParam("userName") String username,@RequestParam("password") String pwd) {
		if(user.containsKey(username)& pwd.equals(user.get(username)))
			return "loginsuccess";
		else return "loginfail";
	}
	
	@PostMapping("/registerpage")
	//@ResponseBody
	public String register(@RequestParam("userName") String username,@RequestParam("password") String pwd) {
		   user.put(username, pwd);
			return "login";
		//else return "loginfailed";
	}
}
