package com.jwt.jwtauth.model;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class UserAdditionalInfo {


	private String a;

	private List<String> b;

	private Double c;

	private String d;

	private String e;

	private Map<String, item> f;

	private Map<String, Double> g;

	private Double h;

	private List<Book> i;

	private Map<String, String> j;

	private String k;


}
