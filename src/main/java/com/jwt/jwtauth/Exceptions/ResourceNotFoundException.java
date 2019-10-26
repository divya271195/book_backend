package com.jwt.jwtauth.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import com.jwt.jwtauth.model.Systemerror;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -9079454849611061074L;
	
	private Systemerror err;


	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(Systemerror err) {
		super(err.getMsg());
		this.err=err;
		
		
		
		

	}
	
}
