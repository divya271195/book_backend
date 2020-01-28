package com.jwt.jwtauth.Controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.jwt.jwtauth.model.ApplicationUser;
import com.jwt.jwtauth.model.DBApplicationUser;

@Repository
@Transactional
public class UserService {

	@PersistenceContext
	private EntityManager entityManager;

	public long insert(DBApplicationUser user) {
		entityManager.persist(user);
		return user.getId();
	}

	public DBApplicationUser find(long id) {
		return entityManager.find(DBApplicationUser.class, id);
	}

	public List<ApplicationUser> findAll() {
		// Query query = entityManager.createNamedQuery("query_find_all_users", DBApplicationUser.class);
		// return query.getResultList();
		return null;

	}
}
