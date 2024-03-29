package com.myretail.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class MyRetailSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic().and().authorizeRequests().antMatchers("/products/admin/**").hasRole("ADMIN").and().csrf()
				.disable();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("udhay").password("{noop}udhay1995").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
	}
}
