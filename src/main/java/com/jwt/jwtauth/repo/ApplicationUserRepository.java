package com.jwt.jwtauth.repo;
import com.jwt.jwtauth.model.ApplicationUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

	ApplicationUser findByUsername(String username);

}
