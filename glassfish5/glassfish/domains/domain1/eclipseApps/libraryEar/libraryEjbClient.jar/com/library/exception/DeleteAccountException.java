package com.library.exception;

public class DeleteAccountException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String message;

	public DeleteAccountException(String message) {
		super(message);
		this.message = message;
	}

	public String message() {
		return this.message;
	}
}
