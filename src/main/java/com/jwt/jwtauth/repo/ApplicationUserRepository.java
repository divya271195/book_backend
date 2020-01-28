package com.jwt.jwtauth.repo;

import com.jwt.jwtauth.model.DBApplicationUser;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApplicationUserRepository extends JpaRepository<DBApplicationUser, Long> {

	DBApplicationUser findByUsername(String username);

	@Query("select  u from DBApplicationUser u order by u.id desc ")
	List<DBApplicationUser> findUsers();

}
