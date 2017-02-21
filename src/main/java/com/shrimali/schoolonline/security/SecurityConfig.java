package com.shrimali.schoolonline.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.shrimali.schoolonline.config.AppConfiguration;
import com.shrimali.schoolonline.constants.Roles;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired
	private AppConfiguration appConfiguration;

	@Autowired
	protected void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		 http
		 	.authorizeRequests()
		 	.antMatchers("/admin/**").hasRole(Roles.ROLE_ADMIN.getRole())
		 	.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage(appConfiguration.getSpringSecurity().getLoginUrl()).permitAll()
			.successHandler(customAuthenticationSuccessHandler())
//			.defaultSuccessUrl(appConfiguration.getSpringSecurity().getDefaultSuccessUrl())
			.failureHandler(customAuthenticationFailureHandler())
			.and()
			.logout().permitAll()
			.logoutSuccessUrl(appConfiguration.getSpringSecurity().getLogoutSuccessUrl())
			.and().exceptionHandling().accessDeniedPage("/denied"); ;
	}

	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationFailureHandler customAuthenticationFailureHandler() {
		return new CustomAuthenticationFailureHandler();
	}

	@Bean
	public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
		return new CustomAuthenticationSuccessHandler();
	}
}
