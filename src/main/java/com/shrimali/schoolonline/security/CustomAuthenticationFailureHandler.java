package com.shrimali.schoolonline.security;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.shrimali.schoolonline.constants.AppConstants;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Autowired
	@Qualifier("securityMessageSource")
	private MessageSource messageSource;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String error = "";

		if (exception instanceof AccountExpiredException) {
			error = messageSource.getMessage("springSecurity.errors.login.expired", null, Locale.US);
		} else if (exception instanceof CredentialsExpiredException) {
			error = messageSource.getMessage("springSecurity.errors.login.passwordExpired", null, Locale.US);
		} else if (exception instanceof DisabledException) {
			error = messageSource.getMessage("springSecurity.errors.login.disabled", null, Locale.US);
		} else if (exception instanceof LockedException) {
			error = messageSource.getMessage("springSecurity.errors.login.locked", null, Locale.US);
		} else {
			error = messageSource.getMessage("springSecurity.errors.login.fail", null, Locale.US);
		}
		request.getSession().setAttribute(AppConstants.AUTHENTICATION_ERROR, error);
		response.sendRedirect("/login");
		// TODO handle API end points
	}
}
