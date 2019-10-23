
package com.jwt.jwtauth.repo;


import com.jwt.jwtauth.model.Order;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface Orderrepo extends JpaRepository<Order, Integer> {


	@Query("select u from Order u where u.username = ?1")
	List<Order> findByName(String username);

	@Query("select u from Order u where u.username = ?1 and u.orderDate=?2")
	Order findByDate(String username, Date dateof);

}
