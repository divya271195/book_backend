package com.jwt.jwtauth.model;

import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)

@Getter
@Setter
public class Order {


	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderid;
	@Column(name = "customeruname")
	private String username;


	@Column(name = "orderDate")
	private int orderDate;


	@OneToMany(cascade = {CascadeType.ALL})
	@Column(name = "Order_item")
	private List<item> items;


	@Column(name = "subtotal")
	private double subtotal;

	@Column(name = "status")
	private String status;


}
