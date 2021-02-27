package com.spring.api.service;

import com.spring.api.model.emailTemplate;
import com.spring.api.model.userInfo;

public interface EmailService {

	public void sendTextEmail(emailTemplate emailTemplates);

	public boolean sendForgotPasswordLink(userInfo userInfos) throws Exception;
	
	public boolean changeUserPassword(userInfo userInfos, String newPassword);

}
