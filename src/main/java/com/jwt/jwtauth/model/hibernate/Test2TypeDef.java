package com.jwt.jwtauth.model.hibernate;

import com.jwt.jwtauth.model.test2;

public class Test2TypeDef extends CustomUserType {

	@Override
	public Class<?> returnedClass() {
		return test2.class;
	}

}
