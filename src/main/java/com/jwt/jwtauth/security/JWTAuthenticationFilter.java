// package com.jwt.jwtauth.security;
//
//
//// import com.jwt.jwtauth.Exceptions.CustomAuthenticationException;
// import com.jwt.jwtauth.Response;
// import com.jwt.jwtauth.SignInResponse;
//// import com.jwt.jwtauth.Exceptions.CustomAuthenticationException;
// import com.jwt.jwtauth.Exceptions.ExceptionResponse;
// import com.jwt.jwtauth.Exceptions.ResourceNotFoundException;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.google.gson.Gson;
// import com.jwt.jwtauth.user.ApplicationUser;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.AuthenticationException;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// import org.springframework.web.bind.annotation.RestController;
// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import java.io.IOException;
// import static com.jwt.jwtauth.security.SecurityConstants.EXPIRATION_TIME;
// import static com.jwt.jwtauth.security.SecurityConstants.SECRET;
// import static com.jwt.jwtauth.security.SecurityConstants.HEADER_STRING;
// import static com.jwt.jwtauth.security.SecurityConstants.TOKEN_PREFIX;
// import java.util.ArrayList;
// import java.util.Date;
//// @RestController
//
// public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//
// private AuthenticationManager authenticationManager;
//
// //public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
//
// //this.authenticationManager = authenticationManager;
//
// //}
//
// public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
// setFilterProcessesUrl("/store/login");
//
// }
//
// @Override
//
// public Authentication attemptAuthentication(HttpServletRequest req,
//
// HttpServletResponse res) throws ResourceNotFoundException {
//
// try {
//
// ApplicationUser creds = new ObjectMapper()
//
// .readValue(req.getInputStream(), ApplicationUser.class);
//
// // if(creds==null) {
// // throw new ResourceNotFoundException("wrong credentials");
// //}
// return authenticationManager.authenticate(
//
// new UsernamePasswordAuthenticationToken(
//
// creds.getUsername(),
//
// creds.getPassword(),
//
// new ArrayList<>())
//
// );
//
// }
// catch (Exception e) {
//
// throw new ResourceNotFoundException("wrong credentials exception",401);
//
// }}
//
//
//
// @Override
//
// protected void successfulAuthentication(HttpServletRequest req,
//
// HttpServletResponse res,
//
// FilterChain chain,
//
// Authentication auth) throws IOException, ServletException {
//
// SignInResponse signInResponse = new SignInResponse();
//
// String token = Jwts.builder()
//
// .setSubject(((User) auth.getPrincipal()).getUsername())
// .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//
//
// .signWith(SignatureAlgorithm.HS512, SECRET)
//
// .compact();
//
// res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
//
// signInResponse.setAccessToken(token);
// res.getWriter().write(new Gson().toJson(signInResponse));
//
//
// }
//
//
// @Override
// protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
// AuthenticationException failed) throws IOException, ServletException {
// //ExceptionResponse res = new ExceptionResponse();
// //res.setErrorCode(401);
// //res.setErrorMessage("Wrong credentials");
// //CustomAuthenticationException authException = (CustomAuthenticationException) failed;
// //res.setMessage(authException.getMessage());
// throw new ResourceNotFoundException("wrong credentials ",401);
// //response.getWriter().write(new Gson().toJson(res));
// }
// }


package com.jwt.jwtauth.security;


import com.jwt.jwtauth.Response;
import com.jwt.jwtauth.SignInResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jwt.jwtauth.model.ApplicationUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.core.env.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static com.jwt.jwtauth.security.SecurityConstants.EXPIRATION_TIME;
import static com.jwt.jwtauth.security.SecurityConstants.SECRET;
import static com.jwt.jwtauth.security.SecurityConstants.HEADER_STRING;
import static com.jwt.jwtauth.security.SecurityConstants.TOKEN_PREFIX;
import java.util.ArrayList;
import java.util.Date;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	//@Autowired
	//private Environment env;

	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {

		this.authenticationManager = authenticationManager;

	}
	

	@Override

	public Authentication attemptAuthentication(HttpServletRequest req,

			HttpServletResponse res) throws AuthenticationException {

		try {

			ApplicationUser creds = new ObjectMapper()

					.readValue(req.getInputStream(), ApplicationUser.class);
			//String role=creds.getRole();
			//String path = env.getProperty("admin.url");
			  
			//if(role=="USER") {
				  
				
		//	}
			

			return authenticationManager.authenticate(

					new UsernamePasswordAuthenticationToken(

							creds.getUsername(),

							creds.getPassword(),

							new ArrayList<>())

			);
			
			

		} catch (IOException e) {

			throw new RuntimeException(e);

		}

	}

	@Override

	protected void successfulAuthentication(HttpServletRequest req,

			HttpServletResponse res,

			FilterChain chain,

			Authentication auth) throws IOException, ServletException {

		SignInResponse signInResponse = new SignInResponse();

		String token = Jwts.builder()

				.setSubject(((User) auth.getPrincipal()).getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))


				.signWith(SignatureAlgorithm.HS512, SECRET)

				.compact();

		res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);

		signInResponse.setAccessToken(token);
		res.getWriter().write(new Gson().toJson(signInResponse));

	}

	

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		Response res = new Response();
		res.setStatus(401);
		res.setMessage("Wrong Credentials ");
		log.error(res+"");
		response.getWriter().write(new Gson().toJson(res));
	}
}
