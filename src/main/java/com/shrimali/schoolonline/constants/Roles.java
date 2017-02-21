package com.shrimali.schoolonline.constants;

public enum Roles {

	ROLE_ADMIN("ADMIN"), ROLE_USER("USER");

	String role;

	Roles(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

}
