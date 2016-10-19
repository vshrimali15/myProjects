package com.shrimali.schoolonline.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shrimali.schoolonline.entities.Role;
import com.shrimali.schoolonline.exceptions.BlankOrNullArgumentException;
import com.shrimali.schoolonline.repository.RoleRepository;
import com.shrimali.schoolonline.services.GenericService;

@Component
public class RoleServiceImpl implements GenericService<Role> {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void save(Role role) {
		roleRepository.save(role);
	}

	@Override
	public void update(Role role) {
		roleRepository.save(role);
	}

	@Override
	public void delete(Long roleId) throws BlankOrNullArgumentException {
		if (roleId == null) {
			throw new BlankOrNullArgumentException("Role Id is blank or null");
		}
		roleRepository.delete(roleId);
	}

	@Override
	public List<Role> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
