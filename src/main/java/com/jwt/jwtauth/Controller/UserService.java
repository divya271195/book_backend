package com.jwt.jwtauth.Controller;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import com.jwt.jwtauth.model.ApplicationUser;
@Repository
@Transactional
public class UserService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(ApplicationUser user) {
		entityManager.persist(user);
		return user.getId();
	}

	public ApplicationUser find(long id) {
		return entityManager.find(ApplicationUser.class, id);
	}
	
	public List<ApplicationUser> findAll() {
//		Query query = entityManager.createNamedQuery(
//				"query_find_all_users",ApplicationUser.class);
//		return query.getResultList();
//		 
		List<ApplicationUser> users = entityManager
				.createQuery("select u from ApplicationUser u")
				.unwrap( org.hibernate.query.Query.class )
				.setResultTransformer( Transformers.aliasToBean( ApplicationUser.class ) )
				.getResultList();
	
	return users;}
}