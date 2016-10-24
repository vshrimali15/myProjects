package com.shrimali.schoolonline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shrimali.schoolonline.security.SecurityService;

@Controller
public class HomeController {

	@Autowired
	private SecurityService securityService;

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/user/home")
	public String userHome() {
		return "userHome";
	}

	@RequestMapping("/admin/home")
	public String adminHome() {
		return "adminHome";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
}
