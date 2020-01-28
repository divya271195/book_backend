package com.jwt.jwtauth.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor

@TypeDefs({@TypeDef(name = "AddressINfoType", typeClass = AddressINfoTypeDef.class),
		@TypeDef(name = "ContactInfoType", typeClass = ContactInfoTypeDef.class),
		@TypeDef(name = "CourseInfoType", typeClass = CourseInfoTypeDef.class),
		@TypeDef(name = "CardDetailType", typeClass = CardDetailTypeDef.class),
		@TypeDef(name = "RoleDetailType", typeClass = RoleDetailTypeDef.class),
		@TypeDef(name = "Test1Type", typeClass = Test1TypeDef.class),
		@TypeDef(name = "Test2Type", typeClass = Test2TypeDef.class),
		@TypeDef(name = "UserAdditionalInfoType", typeClass = UserAdditionalInfotypeDef.class)})


@NamedQuery(query = "select u from ApplicationUser u", name = "query_find_all_users")
public class ApplicationUser implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String name;
	@Column
	private String address;
	@Column
	private String email;
	@Column
	private String role;
	@Column
	private String contact;
	@Type(type = "AddressINfoType")
	private AddressINfo addressINfo;
	@Type(type = "ContactInfoType")
	private ContactInfo contactinfo;
	@Type(type = "CourseInfoType")
	private CourseInfo courseinfo;
	@Type(type = "CardDetailType")
	private CardDetail carddetail;
	@Type(type = "RoleDetailType")
	private roleDetail roledetail;
	@Type(type = "Test1Type")
	private test1 test1;
	@Type(type = "Test2Type")
	private test2 test2;
	@Type(type = "UserAdditionalInfoType")
	private UserAdditionalInfo useradditionalinfo;


}
