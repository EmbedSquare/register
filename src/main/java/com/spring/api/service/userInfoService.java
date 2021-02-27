package com.spring.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.spring.api.model.userInfo;
import com.spring.api.repository.userDetailsRepository;

@Repository
@Transactional
public class userInfoService {

	@Autowired
	private userDetailsRepository userDatailsRepository;

	public userInfo getUserInfoByUserName(String userName) {
		short enabled = 1;
		return userDatailsRepository.findByUserNameAndEnabled(userName, enabled);
	}

	public List<userInfo> getAllActiveUserInfo() {
		return userDatailsRepository.findAllByEnabled((short) 1);
	}

	public userInfo registerUser(userInfo userInfos) {
		userInfos.setPassword(new BCryptPasswordEncoder().encode(userInfos.getPassword()));
		return userDatailsRepository.save(userInfos);
	}

	public userInfo getAllUserInfo(String userName) {
		short enabled = 1;
		return userDatailsRepository.findByUserNameAndEnabled(userName, enabled);
	}

	public userInfo updateUser(userInfo userRecord) {
		return userDatailsRepository.save(userRecord);
	}

	public userInfo deleteUser(int Id) {
		userDatailsRepository.deleteById(Id);
		return null;
	}

}
