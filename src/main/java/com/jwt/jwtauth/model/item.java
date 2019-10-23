package com.jwt.jwtauth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item") // the table in the database that will contain our phones data
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter

public class item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "bookid")
	private int bookid;


	@Column(name = "quantity")
	private int quantity;


	@Column(name = "orderid")
	private int orderid;

}
