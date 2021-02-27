package com.spring.api.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.api.model.passwordToken;
import com.spring.api.model.emailTemplate;
import com.spring.api.model.userInfo;
import com.spring.api.repository.passwordTokenRepository;
import com.spring.api.repository.userDetailsRepository;
import com.spring.api.model.forgotPasswordRequest;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private passwordTokenRepository passwordTokenRepository;

	@Autowired
	private userDetailsRepository userRepository;

	@Value("${email.address}")
	private String attchEmailAddr;

	@Value("${email.forgotPasswordLink}")
	private String forgotPasswordLink;

	@Override
	public void sendTextEmail(emailTemplate emailTemplates) {
		SimpleMailMessage msg = new SimpleMailMessage();
		try {
			if (emailTemplates.getSendTo().contains(",")) {
				String[] emails = emailTemplates.getSendTo().split(",");
				int receipantSize = emails.length;
				for (int i = 0; i < receipantSize; i++) {
					msg.setTo(emails[i]);
					msg.setSubject(emailTemplates.getSubject());
					msg.setText(emailTemplates.getBody());

					javaMailSender.send(msg);
				}

			} else {
				msg.setTo(emailTemplates.getSendTo());
				msg.setSubject(emailTemplates.getSubject());
				msg.setText(emailTemplates.getBody());

				javaMailSender.send(msg);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean sendForgotPasswordLink(userInfo userInfos) throws Exception {
		

		UUID token = UUID.randomUUID();
		passwordToken passwordToken = new passwordToken(userInfos.getId(), token.toString());

		forgotPasswordRequest forgotPasswordRequests = new forgotPasswordRequest();
		String forgotPasswordLinkFinal = forgotPasswordLink.replace("@token", passwordToken.getToken());

		forgotPasswordRequests.setEmail(userInfos.getEmail());
		forgotPasswordRequests.setResetPasswordLink(forgotPasswordLinkFinal);

		SimpleMailMessage msg = new SimpleMailMessage();

		msg.setTo(forgotPasswordRequests.getEmail());
		msg.setSubject("Forgot Password");
		msg.setText(forgotPasswordRequests.getResetPasswordLink());
		javaMailSender.send(msg);

		passwordTokenRepository.save(passwordToken);

		return true;
	}

	@Override
	public boolean changeUserPassword(userInfo userInfos, String newPassword) {
		if (userInfos != null) {

			if (newPassword != null) {

				String encodedNewPassword = new BCryptPasswordEncoder().encode(newPassword);

				userInfos.setPassword(encodedNewPassword);
				userRepository.save(userInfos);
				return true;
			}
		}
		return false;
	}

}
