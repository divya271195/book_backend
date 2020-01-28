package com.jwt.jwtauth.user;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import static java.util.Collections.emptyList;
import com.jwt.jwtauth.model.ApplicationUser;
import com.jwt.jwtauth.repo.ApplicationUserRepository;

@Service

public class UserDetailsServiceImpl implements UserDetailsService {

	private ApplicationUserRepository applicationUserRepository;

	public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {

		this.applicationUserRepository = applicationUserRepository;

	}
	/*
	 * private Set getAuthority(ApplicationUser user) { Set authorities = new HashSet<>(); user.getRoles().forEach(role
	 * -> { authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName())); }); return authorities; }
	 */

	@Override

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// DBApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
		//
		//
		// if (applicationUser == null) {
		//
		// throw new UsernameNotFoundException(username);
		//
		// }
		//
		// //userapp userPrincipal = new userapp(applicationUser);
		//
		// // return userPrincipal;
		//
		//
		// return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
		return null;

	}

}
