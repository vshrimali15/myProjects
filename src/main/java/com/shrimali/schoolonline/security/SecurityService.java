package com.shrimali.schoolonline.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shrimali.schoolonline.entities.User;

@Service
public class SecurityService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public boolean isLoggedIn() {
		User user = null;
		try {
			user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {

		}
		if (user != null) {
			return true;
		}
		return false;
	}

	public User getCurrentLoggedInUser() {
		User user = null;
		if (!isLoggedIn()) {
			return null;
		}
		try {
			user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {

		}
		return user;
	}

	public String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}

	public Object getPrincipal() {
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
}
