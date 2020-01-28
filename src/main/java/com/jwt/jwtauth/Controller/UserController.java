package com.jwt.jwtauth.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.jwtauth.model.ApplicationUser;
import com.jwt.jwtauth.model.UserResponse;
import com.jwt.jwtauth.model.DBApplicationUser;
import com.jwt.jwtauth.repo.ApplicationUserRepository;

@RestController

@RequestMapping("/users")

public class UserController {

	@Autowired
	private ApplicationUserRepository applicationUserRepository;
	@Autowired
	private UserService userService;

	//public UserController(ApplicationUserRepository applicationUserRepository) {

		//this.applicationUserRepository = applicationUserRepository;

	//}

	@GetMapping("/") // GET Method for getting all customer information
	public List<ApplicationUser> getAllUsers() {
		UserResponse userresponse=new UserResponse();
		applicationUserRepository.findAll().forEach(user -> {
			userresponse.getUserList().add(user.toDomain());
		});
		return userresponse.getUserList();

	}


	@GetMapping("/default") // GET Method for getting all customer information
	public List<DBApplicationUser> getAllusers() {

		return applicationUserRepository.findAll();
	}

	@PostMapping("/sign-up")

	public DBApplicationUser signUp(@Valid @RequestBody ApplicationUser user) {
		DBApplicationUser newUser=new DBApplicationUser().from(user);
		
		
		return applicationUserRepository.save(newUser);

	}

	@PostMapping("/sign-up/bulk")

	public void signUpBulk(@Valid @RequestBody List<ApplicationUser> user) {

		// address(user.getAddress())
		// .email(user.getEmail()).password(user.getPassword()).role(user.getRole()).username(user.getUsername()).build();
		//
		for (ApplicationUser appuser : user) {
			applicationUserRepository.save(new DBApplicationUser().from(appuser));
		}

	}

	private List<ApplicationUser> findByJsonSearch(ApplicationUser userFilter) {
		return null;
	}
}
