// package com.jwt.jwtauth.security;
//
// import io.jsonwebtoken.Jwts;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.AuthenticationException;
// import org.springframework.security.core.context.SecurityContextHolder;
// import javax.servlet.http.HttpServletResponse;
// import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
// import com.jwt.jwtauth.Response;
//// import com.jwt.jwtauth.Exceptions.CustomAuthenticationException;
// import com.jwt.jwtauth.Exceptions.ExceptionResponse;
// import com.jwt.jwtauth.Exceptions.ResourceNotFoundException;
// import com.google.gson.Gson;
// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletRequest;
//// import javax.servlet.http.HttpServletResponse;
// import java.io.IOException;
// import java.util.ArrayList;
// import static com.jwt.jwtauth.security.SecurityConstants.SECRET;
// import static com.jwt.jwtauth.security.SecurityConstants.HEADER_STRING;
// import static com.jwt.jwtauth.security.SecurityConstants.TOKEN_PREFIX;
//
//
// public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
//
// public JWTAuthorizationFilter(AuthenticationManager authManager) {
//
// super(authManager);
//
// }
//
// @Override
//
// protected void doFilterInternal(HttpServletRequest req,
//
// HttpServletResponse res,
//
// FilterChain chain) throws IOException, ServletException {
//
// String header = req.getHeader(HEADER_STRING);
//
// if (header == null || !header.startsWith(TOKEN_PREFIX)) {
//
// chain.doFilter(req, res);
//
// return;
//
// }
//
// UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
//
// SecurityContextHolder.getContext().setAuthentication(authentication);
//
// chain.doFilter(req, res);
//
// }
//
// private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) throws IOException {
//
// String token = request.getHeader(HEADER_STRING);
//
// try {
// if (token != null) {
//
// // parse the token.
//
// String user = Jwts.parser()
//
// .setSigningKey(SECRET)
//
// .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
//
// .getBody()
//
// .getSubject();
//
// if (user != null) {
//
// return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
//
// }
// }
// } catch (Exception ex) {
// onUnsuccessfulAuthentication(request, null, null);
//
// }
// return null;
//
// }
//
// // return null;
//
//
// // }
//
// @Override
// protected void onUnsuccessfulAuthentication(HttpServletRequest req, HttpServletResponse res,
// AuthenticationException failed) throws IOException {
//
// // Response response = new Response();
// //response.setStatus(403);
// //response.setMessage("The token is either invalid or expired");
// //ExceptionResponse response = new ExceptionResponse();
// //response.setErrorCode(401);
// //res.setErrorMessage("Wrong credentials");
// //CustomAuthenticationException authException = (CustomAuthenticationException) failed;
// //res.setMessage(authException.getMessage());
// throw new ResourceNotFoundException("wrong credentials ",404);
//
// // res.getWriter().write(new Gson().toJson(response));
// }
//
// }


package com.jwt.jwtauth.security;
import java.util.regex.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import com.jwt.jwtauth.Response;
import com.jwt.jwtauth.model.ApplicationUser;
import com.jwt.jwtauth.repo.ApplicationUserRepository;
import com.google.gson.Gson;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import org.springframework.security.core.userdetails.UserDetailsService;
import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import static com.jwt.jwtauth.security.SecurityConstants.SECRET;
import static com.jwt.jwtauth.security.SecurityConstants.HEADER_STRING;
import static com.jwt.jwtauth.security.SecurityConstants.TOKEN_PREFIX;


public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
	public JWTAuthorizationFilter(AuthenticationManager authManager) {

		super(authManager);

	}

	@Autowired
	private ApplicationUserRepository repo;

	@Override

	protected void doFilterInternal(HttpServletRequest req,

			HttpServletResponse res,

			FilterChain chain) throws IOException, ServletException {

		String header = req.getHeader(HEADER_STRING);


		if (header == null || !header.startsWith(TOKEN_PREFIX)) {

			chain.doFilter(req, res);

			return;

		}

		String token = header.replace(TOKEN_PREFIX, "");
		// boolean a=parse(token,req);
		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
		
		//authentication= parse(token,req);
		
		
		SecurityContextHolder.getContext().setAuthentication(authentication);


		chain.doFilter(req, res);

	}


	public UsernamePasswordAuthenticationToken parse(String token, HttpServletRequest req) throws NullPointerException {
		Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
//		ApplicationUser user = new ApplicationUser();
//		
//		String username = claims.get("username", String.class);
//		user = repo.findByUsername(username);
//		String role = user.getRole();
//		String requestURL = new String(req.getRequestURL().toString());
//		if(requestURL.matches("store/books/admin/**")) {
//			if(!role.equals("ADMIN"))
//				{return null;}
//		}
//
//		return  new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());

	return null;
	}


	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) throws IOException {

		String token = request.getHeader(HEADER_STRING);

		try {
			if (token != null) {

				// parse the token.

				String user = Jwts.parser()

						.setSigningKey(SECRET)

						.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))

						.getBody()

						.getSubject();

				if (user != null) {

					return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());

				}
			}
		} catch (Exception ex) {
			onUnsuccessfulAuthentication(request, null, null);

		}
		return null;

	}

	// return null;

	// }

	@Override
	protected void onUnsuccessfulAuthentication(HttpServletRequest req, HttpServletResponse res,
			AuthenticationException failed) throws IOException {
		Response response = new Response();
		response.setStatus(400);
		response.setMessage("The token is either invalid or expired");
		res.getWriter().write(new Gson().toJson(response));
	}


}
