package com.jwt.jwtauth.repo;


import com.jwt.jwtauth.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Bookrepo extends JpaRepository<Book, Integer> {
	@Query("select u from Book u where u.category = ?1")
	List<Book> findByCategory(String category);

	@Query("select u from Book u where u.author = ?1")
	List<Book> findByAuthor(String author);


	@Query("select u from Book u where u.title = ?1")
	List<Book> findByTitle(String title);

	@Query("select u from Book u where u.id = ?1")
	Book findById(int id);

	@Query("select u.inventory from Book u where u.id = ?1")
	int getinventory(int id);

	@Query("select  u from Book u order by u.rank desc ")
	List<Book> getPopularBook();

	@Query("select u.id,u.title,u.price,u.icon from Book u")
	List<Book> findBookList();


}
