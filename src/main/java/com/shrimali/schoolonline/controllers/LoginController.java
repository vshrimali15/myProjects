package com.shrimali.schoolonline.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shrimali.schoolonline.config.AppConfiguration;
import com.shrimali.schoolonline.constants.AppConstants;
import com.shrimali.schoolonline.security.SecurityService;

@Controller
public class LoginController {

	@Autowired
	private SecurityService securityService;

	@Autowired
	private AppConfiguration appConfiguration;

	@Autowired
	@Qualifier("securityMessageSource")
	private MessageSource messageSource;

	@RequestMapping(value = { "/login", "/" })
	public String login(Model model, HttpServletRequest request) {
		if (securityService.isLoggedIn()) {
			return "redirect:" + appConfiguration.getSpringSecurity().getDefaultSuccessUrl();
		}

		String authenticationError = getAuthenticationErrorAttributes(request);
		if (authenticationError != null) {
			model.addAttribute("errorMessage", authenticationError);
			clearAuthenticationErrorAttributes(request);
		}
		return "login";
	}

	@RequestMapping(value = { "/denied" })
	public String denied(Model model) {

		model.addAttribute("errorTitle", messageSource.getMessage("springSecurity.denied.title", null, Locale.US));
		model.addAttribute("errorMessage", messageSource.getMessage("springSecurity.denied.message", null, Locale.US));

		return "denied";
	}

	protected void clearAuthenticationErrorAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(AppConstants.AUTHENTICATION_ERROR);
	}

	protected String getAuthenticationErrorAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return null;
		}
		return (String) request.getSession().getAttribute(AppConstants.AUTHENTICATION_ERROR);
	}
}
