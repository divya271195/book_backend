package com.jwt.jwtauth.model.hibernate;

import com.jwt.jwtauth.model.CourseInfo;

public class CourseInfoTypeDef extends CustomUserType {

	@Override
	public Class<?> returnedClass() {
		return CourseInfo.class;
	}

}

