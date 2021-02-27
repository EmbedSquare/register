package com.spring.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.spring.api.model.passwordToken;
import com.spring.api.model.userInfo;
import com.spring.api.repository.passwordTokenRepository;
import com.spring.api.service.EmailService;
import com.spring.api.service.userInfoService;
import com.spring.api.model.generatePasswordRequest;

@RestController
public class UserController {

	@Autowired
	private EmailService emailService;

	@Autowired
	private userInfoService userService;

	@Autowired
	private passwordTokenRepository passwordTokenRepository;

	@PostMapping("/forgotPassword")
	public ResponseEntity<?> sendForgotPasswordLinkToUser(@RequestParam String userName) {

		if (userName == null || userName.isEmpty()) {
			String msg = "User name should not be empty";
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}

		userInfo userInfos = userService.getAllUserInfo(userName);
		if (userInfos == null) {

			String msg = "User does not exist with userName: " + userName;
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}

		passwordToken passwordToken = passwordTokenRepository.findByUserId(userInfos.getId());

		if (passwordToken != null) {

			String msg = "URL to update password is already sent to the registered email, Please check your Email.";
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}

		try {
			boolean sendForgotPasswordLink = emailService.sendForgotPasswordLink(userInfos);
			if (sendForgotPasswordLink) {

				return new ResponseEntity<>("URL of update password is sent to the registered email.", HttpStatus.OK);
			} else {

				return new ResponseEntity<>("Failed to send email", HttpStatus.NOT_IMPLEMENTED);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to send link to the registered email Id",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/generatePassword")
	public ResponseEntity<String> generateUserPassword(@RequestBody generatePasswordRequest generatePasswordRequests) {

		if (generatePasswordRequests.getUserName() == null || generatePasswordRequests.getUserName().isEmpty()) {
			String msg = "User name should not be empty";
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}

		if (generatePasswordRequests.getToken() == null || generatePasswordRequests.getToken().isEmpty()) {
			String msg = "Token should not be empty";
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}

		if (generatePasswordRequests.getNewPassword() == null || generatePasswordRequests.getNewPassword().isEmpty()) {
			String msg = "Password should not be empty";
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}

		userInfo userInfos = userService.getUserInfoByUserName(generatePasswordRequests.getUserName());
		if (userInfos == null) {
			String msg = "User does not exist with userName: " + generatePasswordRequests.getUserName();
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}

		passwordToken passwordToken = passwordTokenRepository.findByUserId(userInfos.getId());
		if (passwordToken == null) {
			String msg = "The link to generate password has been expired.";
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}

		if (!passwordToken.getToken().equals(generatePasswordRequests.getToken())) {
			String msg = "The link to generate password has been expired.";
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}

		boolean status = emailService.changeUserPassword(userInfos, generatePasswordRequests.getNewPassword());

		if (status) {
			passwordTokenRepository.delete(passwordToken);
			return new ResponseEntity<>("User password has been changed successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to changed user's password", HttpStatus.NOT_IMPLEMENTED);
		}
	}

}