package com.spring.api.model;

public class forgotPasswordRequest {

	private String Email;

	private String token;

	private String forgotPasswordLink;

	public String getEmail() {
		return Email;
	}

	public void setEmail(String userName) {
		this.Email = userName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getResetPasswordLink() {
		return forgotPasswordLink;
	}

	public void setResetPasswordLink(String forgotPasswordLink) {
		this.forgotPasswordLink = forgotPasswordLink;
	}
}
