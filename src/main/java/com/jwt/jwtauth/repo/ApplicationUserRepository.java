package com.jwt.jwtauth.repo;

import com.jwt.jwtauth.model.ApplicationUser;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

	ApplicationUser findByUsername(String username);

	@Query("select  u from ApplicationUser u order by u.id desc ")
	List<ApplicationUser> findUsers();

}
