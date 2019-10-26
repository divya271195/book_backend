package com.jwt.jwtauth.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Systemerror {
	USER_NOT_FOUND(404,"Requested user is not present "),
	BOOK_NOT_FOUND(404,"Requested book is not present"),
	INTERNAL_SERVER_ERROR(500,"internal server error"),
	AUTHENTICATION_ERROR(401,"unauthorized user");
	
	private int code;
	private String msg;
 
	
		Systemerror( int code, String msg){
		this.code=code;
		this.msg=msg;
		
	}
	
}
