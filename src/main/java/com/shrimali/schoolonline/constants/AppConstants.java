package com.shrimali.schoolonline.constants;

public final class AppConstants {

	/**
	 * Used to hold CustomAuthenticationFailureHandler's custom error message.
	 */
	public static final String AUTHENTICATION_ERROR = "SPRING_SECURITY_AUTHENTICATION_ERROR";

	public static final String ROLE_ADMIN = getRole(Roles.ROLE_ADMIN);

	public static final String ROLE_USER = getRole(Roles.ROLE_USER);

	public static String getRole(Roles role) {
		if (role.toString().contains("_")) {
			return role.toString().substring(role.toString().indexOf('_') + 1);
		}
		return role.toString();
	}
}
