package com.shrimali.schoolonline.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrimali.schoolonline.entities.User;
import com.shrimali.schoolonline.exceptions.BlankOrNullArgumentException;
import com.shrimali.schoolonline.repository.UserRepository;
import com.shrimali.schoolonline.security.SecurityService;
import com.shrimali.schoolonline.services.GenericService;

@Service
@Transactional
public class UserServiceImpl implements GenericService<User> {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SecurityService securityService;

	@Override
	public void save(User user) {
		user.setPassword(securityService.encodePassword(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public void update(User user) {
		user.setPassword(securityService.encodePassword(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public void delete(Long userId) throws BlankOrNullArgumentException {
		if (userId == null || userId.equals("")) {
			throw new BlankOrNullArgumentException("User id can't be blank or null");
		}
		userRepository.delete(userId);
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUser(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}

}
