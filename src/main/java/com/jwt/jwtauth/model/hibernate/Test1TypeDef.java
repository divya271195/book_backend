package com.jwt.jwtauth.model.hibernate;

import com.jwt.jwtauth.model.test1;

public class Test1TypeDef extends CustomUserType {

	@Override
	public Class<?> returnedClass() {
		return test1.class;
	}

}
