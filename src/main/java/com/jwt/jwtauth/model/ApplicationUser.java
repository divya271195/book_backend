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

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;


	@Column(name = "name")
	private String name;


	@Column(name = "address")
	private String address;


	@Column(name = "email")
	private String email;


	@Column(name = "role")
	 private String role;

	/*@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLES", joinColumns = {@JoinColumn(name = "USER_ID")},
			inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
	private Set roles;
*/


	
    public List<String> getRoleList(){
        if(this.role.length() > 0){
            return Arrays.asList(this.role.split(","));
        }
        return new ArrayList<>();
    }

	@Size(min = 3, max = 50)
	private String contact;


}
