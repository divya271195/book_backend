package com.jwt.jwtauth.Exceptions;


public enum ErrorCode {
	IO_EXCEPTION(400), NUMBER_FORMAT_EXCEPTION(2), NOT_FOUND(0), BAD_REQUEST(6), SERVER_NOT_FOUND(8);

	private int code;

	public int getCode() {
		return this.code;
	}

	private ErrorCode(int code) {
		this.code = code;
	}

}

