package com.shrimali.schoolonline.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shrimali.schoolonline.entities.User;
import com.shrimali.schoolonline.services.impl.UserServiceImpl;

@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserServiceImpl userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userService.getUser(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid Username or Password");
		}
		return user;
	}
}
