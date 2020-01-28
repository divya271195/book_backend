package com.jwt.jwtauth.model;

import java.util.ArrayList;
import java.util.List;

public class UserResponse {


	private List<ApplicationUser> userList;

	public List<ApplicationUser> getUserList() {
		if (userList == null) {
			userList = new ArrayList<>();
		}
		return userList;
	}

}
