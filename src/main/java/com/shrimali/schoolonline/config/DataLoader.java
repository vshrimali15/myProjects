package com.shrimali.schoolonline.config;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.shrimali.schoolonline.constants.Roles;
import com.shrimali.schoolonline.entities.Role;
import com.shrimali.schoolonline.entities.User;
import com.shrimali.schoolonline.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Transactional
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		Set<Role> admin_roles = new HashSet<>();
		Role admin_role = new Role(Roles.ROLE_ADMIN, "host");
		admin_roles.add(admin_role);
		User admin_user = new User("admin", "12345", "admin", "host", admin_roles);

		Set<Role> user_roles = new HashSet<>();
		Role user_role = new Role(Roles.ROLE_USER, "host");
		user_roles.add(user_role);
		User user = new User("user", "12345", "user", "host", user_roles);

		userRepository.save(admin_user);
		userRepository.save(user);
	}

}
