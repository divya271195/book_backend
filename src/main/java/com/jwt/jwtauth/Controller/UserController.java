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
import com.jwt.jwtauth.repo.ApplicationUserRepository;

@RestController

@RequestMapping("/users")

public class UserController {

	private ApplicationUserRepository applicationUserRepository;
	@Autowired
	private UserService userService;

	public UserController(ApplicationUserRepository applicationUserRepository,

			BCryptPasswordEncoder bCryptPasswordEncoder) {

		this.applicationUserRepository = applicationUserRepository;

	}

	@GetMapping("/") // GET Method for getting all customer information
	public List<ApplicationUser> getAllBooks() {
		// return applicationUserRepository.findUsers();
		return userService.findAll();

	}


	@GetMapping("/default") // GET Method for getting all customer information
	public List<ApplicationUser> getAllusers() {

		return applicationUserRepository.findAll();
	}

	@PostMapping("/sign-up")

	public ApplicationUser signUp(@Valid @RequestBody ApplicationUser user) {

		// address(user.getAddress())
		// .email(user.getEmail()).password(user.getPassword()).role(user.getRole()).username(user.getUsername()).build();
		//
		return applicationUserRepository.save(user);

	}

	@PostMapping("/sign-up/bulk")

	public void signUpBulk(@Valid @RequestBody List<ApplicationUser> user) {

		// address(user.getAddress())
		// .email(user.getEmail()).password(user.getPassword()).role(user.getRole()).username(user.getUsername()).build();
		//
		for (ApplicationUser appuser : user) {
			applicationUserRepository.save(appuser);
		}

	}

	private List<ApplicationUser> findByJsonSearch(ApplicationUser userFilter) {
		return null;
	}
}
