package com.jwt.jwtauth;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInResponse extends Response {

	// private User user;
	private String accessToken;
}
