package com.example.mydemoappsuper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	private final LoggedManagmentService loggedManagmentService;
	
	public MainController(LoggedManagmentService loggedManagmentService) {
		this.loggedManagmentService = loggedManagmentService;
	}
	
	@GetMapping("/main")
	public String home(@RequestParam(required = false) String logout, Model model) {
		if (logout != null) {
			loggedManagmentService.setUsername(null);
		}
		String username = loggedManagmentService.getUsername();
		if(username == null) {
			return "redirect:/";
		}
		model.addAttribute("username", username);
		return "main.html";
	}

}
