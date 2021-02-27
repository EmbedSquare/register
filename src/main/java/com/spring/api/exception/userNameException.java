package com.spring.api.exception;

public class userNameException extends Exception {

	public userNameException() {
		super("Register valid User");
	}

	public userNameException(String message) {
		super(message);

	}

}
