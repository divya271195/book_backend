package com.jwt.jwtauth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.google.gson.annotations.JsonAdapter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "applicationusers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
// @NamedQuery(query = "select u from ApplicationUser u", name = "query_find_all_users")
public class DBApplicationUser extends BaseModel<DBApplicationUser, ApplicationUser> {
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
	@Column
	@JsonAdapter(JsonStringSerializer.class)
	private String addressINfo;

	@Column
	@JsonAdapter(JsonStringSerializer.class)
	private String contactinfo;

	@Column
	@JsonAdapter(JsonStringSerializer.class)
	private String courseinfo;

	@Column
	@JsonAdapter(JsonStringSerializer.class)
	private String carddetail;

	@Column
	@JsonAdapter(JsonStringSerializer.class)
	private String roledetail;

	@Column
	@JsonAdapter(JsonStringSerializer.class)
	private String test1;

	@Column
	@JsonAdapter(JsonStringSerializer.class)
	private String test2;

	@Column
	@JsonAdapter(JsonStringSerializer.class)
	private String useradditionalinfo;

	@Override
	public ApplicationUser toDomain() {
		return new GsonMapper().convert(this);
	}

	@Override
	public DBApplicationUser from(ApplicationUser dataModel) {
		return new GsonMapper().convertdb(dataModel);
	}

}
