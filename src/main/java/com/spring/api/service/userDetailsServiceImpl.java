package com.spring.api.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.api.model.userInfo;

@Service
public class userDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private userInfoService userInfoDAO;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		userInfo userInfo = userInfoDAO.getUserInfoByUserName(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
		return new User(userInfo.getUserName(), userInfo.getPassword(), Arrays.asList(authority));
	}
}