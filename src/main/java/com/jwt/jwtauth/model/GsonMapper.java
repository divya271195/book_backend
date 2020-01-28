package com.jwt.jwtauth.model;


import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GsonMapper {
	public ApplicationUser convert(DBApplicationUser input) {
		Gson gson = new Gson();
		String jsonString = gson.toJson(input);

		// ApplicationUser customerDomainObject =
		return gson.fromJson(jsonString, ApplicationUser.class);
	}

	public DBApplicationUser convertdb(ApplicationUser input) {
		Gson gson = new Gson();
		String jsonString = gson.toJson(input);

		// ApplicationUser customerDomainObject =
		return gson.fromJson(jsonString, DBApplicationUser.class);
	}


}
