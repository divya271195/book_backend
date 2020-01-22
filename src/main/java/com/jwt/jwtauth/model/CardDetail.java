package com.jwt.jwtauth.model;

import lombok.Data;

@Data
public class CardDetail {
	
	private String cvv;
	private String cardno;
	private String expiary;
	
}