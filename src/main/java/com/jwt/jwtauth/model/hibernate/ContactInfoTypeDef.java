package com.jwt.jwtauth.model.hibernate;

import com.jwt.jwtauth.model.ContactInfo;

public class ContactInfoTypeDef extends CustomUserType{
		
		@Override
		public Class<?> returnedClass() {
			return ContactInfo.class;
		}

}
