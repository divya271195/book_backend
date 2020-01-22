package com.jwt.jwtauth.model.hibernate;

import com.jwt.jwtauth.model.roleDetail;

public class RoleDetailTypeDef extends CustomUserType {

	@Override
	public Class<?> returnedClass() {
		return roleDetail.class;
	}

}
