package com.shrimali.schoolonline.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shrimali.schoolonline.entities.User;
import com.shrimali.schoolonline.exceptions.BlankOrNullArgumentException;
import com.shrimali.schoolonline.repository.UserRepository;
import com.shrimali.schoolonline.services.GenericService;

@Component
public class UserServiceImpl implements GenericService<User> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public void update(User user) {
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

}
