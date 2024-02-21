package com.example.mydemoappsuper;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
	
	private final LoggedManagmentService loggedManagmentService;
	
	private String username;
	private String password;
	
	
	public LoginProcessor(LoggedManagmentService loggedManagmentService) {
		this.loggedManagmentService = loggedManagmentService;
	}
	
	public boolean login(){
		String username = this.getUsername();
		String password =  this.getPassword();
		
		boolean loginResult = false;
		if ("admin".equals(username) && "password".equals(password)) {
			loginResult = true;
			loggedManagmentService.setUsername(username);
		}
		return loginResult;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
