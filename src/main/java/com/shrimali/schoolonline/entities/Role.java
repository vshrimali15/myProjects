package com.shrimali.schoolonline.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.shrimali.schoolonline.constants.Roles;

@Entity
@Table(name = "role")
public class Role extends BaseEntity implements Serializable, GrantedAuthority {

	private static final long serialVersionUID = 6542218981345175080L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;

	@Enumerated(EnumType.STRING)
	private Roles role;

	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(Roles role, String createdBy) {
		super();
		this.role = role;
		this.createdBy = createdBy;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public Long getRoleId() {
		return roleId;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return getRole().toString();
	}
}