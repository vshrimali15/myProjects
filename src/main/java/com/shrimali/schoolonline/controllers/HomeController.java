package com.shrimali.schoolonline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home() {
		if (true) {
			throw new NullPointerException();
		}
		System.out.println("======================");
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
