package com.jwt.jwtauth.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.jwt.jwtauth.model.hibernate.AddressINfoTypeDef;
import com.jwt.jwtauth.model.hibernate.CardDetailTypeDef;
import com.jwt.jwtauth.model.hibernate.ContactInfoTypeDef;
import com.jwt.jwtauth.model.hibernate.CourseInfoTypeDef;
import com.jwt.jwtauth.model.hibernate.RoleDetailTypeDef;
import com.jwt.jwtauth.model.hibernate.Test1TypeDef;
import com.jwt.jwtauth.model.hibernate.Test2TypeDef;
import com.jwt.jwtauth.model.hibernate.UserAdditionalInfotypeDef;
import javax.persistence.NamedQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor

@TypeDefs({ @TypeDef(name = "AddressINfoType", typeClass = AddressINfoTypeDef.class),
@TypeDef(name = "ContactInfoType", typeClass = ContactInfoTypeDef.class),
@TypeDef(name = "CourseInfoType", typeClass = CourseInfoTypeDef.class),
@TypeDef(name = "CardDetailType", typeClass = CardDetailTypeDef.class),
@TypeDef(name = "RoleDetailType", typeClass = RoleDetailTypeDef.class),
@TypeDef(name = "Test1Type", typeClass = Test1TypeDef.class),
@TypeDef(name = "Test2Type", typeClass = Test2TypeDef.class),
@TypeDef(name = "UserAdditionalInfoType", typeClass = UserAdditionalInfotypeDef.class)

})


@NamedQuery(query = "select u from ApplicationUser u", name = "query_find_all_users")


public class ApplicationUser implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String username;
	private String password;
	private String name;
	private String address;
	private String email;
	private String role;
	private String contact;
	
	@Type(type = "AddressINfoType")
	private AddressINfo addressINfo;
	
	@Type(type = "ContactInfoType")
	private ContactInfo contactInfo;
	
	@Type(type = "CourseInfoType")
	private CourseInfo courseInfo;
	
	@Type(type = "CardDetailType")
	private CardDetail carddetail;
	

	@Type(type = "RoleDetailType")
	private roleDetail roledetail;
	
	@Type(type = "Test1Type")
	private test1 test1detail;
	
	@Type(type = "Test2Type")
	private test2 test2detail;
	
	@Type(type ="UserAdditionalInfoType")
	private UserAdditionalInfo useradditionalinfo;
	
}
