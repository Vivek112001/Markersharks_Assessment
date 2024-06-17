package com.example.Makersharks.Exception;

public class UserExistsException extends RuntimeException {
	public UserExistsException(String message) {
		super(message);
	}
}
