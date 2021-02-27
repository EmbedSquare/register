package com.spring.api.exception;

public class fileStorageException extends Exception {

	public fileStorageException() {
		super("Sorry!! You doesn't have added any file or You trying add duplicate file.");
	}

	public fileStorageException(String message) {
		super(message);

	}

}