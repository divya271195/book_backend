package com.jwt.jwtauth.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@Getter
@Setter

public class ApplicationUser {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private long id;

	@Pattern(regexp="^[A-Za-z0-9]+(?:[ _-][A-Za-z0-9]+)*$")
	@Column(name = "username", nullable = false)
	private String username;

	
	@Column(name = "password", nullable = false)
	private String password;

	@Pattern(regexp = "^[a-zA-Z\\\\s]*$")
	@Column(name = "name")
	private String name;


	@Column(name = "address")
	private String address;

@Pattern(regexp="\\S+@\\S+\\.\\S+")
	@Column(name = "email")
	private String email;


	@Column(name = "role")
	 private String role;

	@Pattern(regexp="^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$")
	private String contact;


}
