package com.jwt.jwtauth.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = -9079454849611061074L;
	private int code;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(final String message, final int code) {
		super(message);
		this.code = code;

	}
	

	public int getCode() {
		return code;
	}


}
