package com.shrimali.schoolonline.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(locations = "classpath:config.properties", prefix = "config", ignoreUnknownFields = false)
public class AppConfiguration {

	@Autowired
	private SpringSecurity springSecurity;

	@Component
	public class SpringSecurity {

		private String defaultSuccessUrl;

		private String loginUrl;

		private String logoutUrl;

		private String logoutSuccessUrl;

		private String restLoginUrl;

		private String restLogoutUrl;

		private String userHomePage;

		private String adminHomePage;

		public String getDefaultSuccessUrl() {
			return defaultSuccessUrl;
		}

		public void setDefaultSuccessUrl(String defaultSuccessUrl) {
			this.defaultSuccessUrl = defaultSuccessUrl;
		}

		public String getLoginUrl() {
			return loginUrl;
		}

		public void setLoginUrl(String loginUrl) {
			this.loginUrl = loginUrl;
		}

		public String getLogoutUrl() {
			return logoutUrl;
		}

		public void setLogoutUrl(String logoutUrl) {
			this.logoutUrl = logoutUrl;
		}

		public String getRestLoginUrl() {
			return restLoginUrl;
		}

		public void setRestLoginUrl(String restLoginUrl) {
			this.restLoginUrl = restLoginUrl;
		}

		public String getRestLogoutUrl() {
			return restLogoutUrl;
		}

		public void setRestLogoutUrl(String restLogoutUrl) {
			this.restLogoutUrl = restLogoutUrl;
		}

		public String getLogoutSuccessUrl() {
			return logoutSuccessUrl;
		}

		public void setLogoutSuccessUrl(String logoutSuccessUrl) {
			this.logoutSuccessUrl = logoutSuccessUrl;
		}

		public String getUserHomePage() {
			return userHomePage;
		}

		public void setUserHomePage(String userHomePage) {
			this.userHomePage = userHomePage;
		}

		public String getAdminHomePage() {
			return adminHomePage;
		}

		public void setAdminHomePage(String adminHomePage) {
			this.adminHomePage = adminHomePage;
		}
	}

	public SpringSecurity getSpringSecurity() {
		return springSecurity;
	}

	public void setSpringSecurity(SpringSecurity springSecurity) {
		this.springSecurity = springSecurity;
	}
}
