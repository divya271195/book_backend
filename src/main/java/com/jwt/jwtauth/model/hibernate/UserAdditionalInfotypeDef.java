package com.jwt.jwtauth.model.hibernate;

import com.jwt.jwtauth.model.UserAdditionalInfo;;

public class UserAdditionalInfotypeDef extends CustomUserType {

	@Override
	public Class<?> returnedClass() {
		return UserAdditionalInfo.class;
	}


}
