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
import com.shrimali.schoolonline.services.GenericService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Transactional
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private GenericService<User> userService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		Set<Role> roles = new HashSet<>();
		Role admin_role = new Role(Roles.ROLE_ADMIN, "host");
		roles.add(admin_role);
		User admin_user = new User("adminUser", "12345", "admin@gmail.com", "host", roles);

		roles = new HashSet<>();
		Role user_role = new Role(Roles.ROLE_USER, "host");
		roles.add(user_role);
		User user = new User("normalUser", "12345", "user@gmail.com", "host", roles);

		userService.save(admin_user);
		userService.save(user);
	}

}
