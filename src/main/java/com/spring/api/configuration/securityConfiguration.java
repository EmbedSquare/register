package com.spring.api.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
/*import org.springframework.security.config.annotation.web.builders.HttpSecurity;*/
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.api.service.userDetailsServiceImpl;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class securityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	userDetailsServiceImpl userDetailsService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().anonymous().disable().authorizeRequests().antMatchers("/oauth/token","/home")
				.permitAll().anyRequest().authenticated();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

		provider.setPasswordEncoder(bCryptPasswordEncoder());

		provider.setUserDetailsService(userDetailsService);
		return provider;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

}