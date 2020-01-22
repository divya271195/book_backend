package com.jwt.jwtauth.model.hibernate;

import com.jwt.jwtauth.model.AddressINfo;

public class AddressINfoTypeDef extends CustomUserType {

	@Override
	public Class<?> returnedClass() {
		return AddressINfo.class;
	}


}
