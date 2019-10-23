package com.jwt.jwtauth.Controller;

import java.util.List;
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

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserController(ApplicationUserRepository applicationUserRepository,

			BCryptPasswordEncoder bCryptPasswordEncoder) {

		this.applicationUserRepository = applicationUserRepository;

		this.bCryptPasswordEncoder = bCryptPasswordEncoder;

	}

	@GetMapping("/") // GET Method for getting all customer information
	public List<ApplicationUser> getAllBooks() {
		return applicationUserRepository.findAll();
	}


	@PostMapping("/sign-up")

	public void signUp(@RequestBody ApplicationUser user) {

		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRole("USER");
		applicationUserRepository.save(user);

	}

}
