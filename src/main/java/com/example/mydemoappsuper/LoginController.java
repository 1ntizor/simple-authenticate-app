package com.example.mydemoappsuper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	
	public LoginProcessor loginProcessor;

	@GetMapping("/")
	public String loginGet() {
		return "login.html";	
	}

	@PostMapping("/")
	public String loginPost(@RequestParam String username, @RequestParam String password, Model model){
		loginProcessor.setUsername(username);
		loginProcessor.setPassword(password);
		boolean loggedIn = loginProcessor.login();
		
		if(loggedIn) {
			return "redirect:/main";
		}
		
		model.addAttribute("message", "Login faild!");
		return "login.html";
	}
	
}
