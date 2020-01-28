package com.jwt.jwtauth.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter

//Extend Base Model in DBModels, to implement the mappers - (domain Entity to Db Entity & vice-versa)
//If partitioning or batch operations  are enabled on a particular entity, extend SuperBaseModel (Refer DbUser)
public abstract class BaseModel<U extends BaseModel<U,V>, V> extends SuperBaseModel<U,V> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
}
