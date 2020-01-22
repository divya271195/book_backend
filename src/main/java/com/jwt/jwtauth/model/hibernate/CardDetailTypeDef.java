package com.jwt.jwtauth.model.hibernate;

import com.jwt.jwtauth.model.CardDetail;

public class CardDetailTypeDef  extends CustomUserType{
	
	@Override
	public Class<?> returnedClass() {
		return CardDetail.class;
	}

}
