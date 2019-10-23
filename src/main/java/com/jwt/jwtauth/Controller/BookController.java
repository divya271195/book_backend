package com.jwt.jwtauth.Controller;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jwt.jwtauth.Exceptions.ResourceNotFoundException;
import com.jwt.jwtauth.model.Book;
import com.jwt.jwtauth.model.StatusUpdateResponse;
import com.jwt.jwtauth.repo.Bookrepo;

@RestController
@RequestMapping("/store/book")


public class BookController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Bookrepo BookRepository;


	@GetMapping("/getlist") // GET Method for reading operation
	public List<Book> getAllBooks() {
		return BookRepository.findAll();
	}

	@GetMapping("/") // GET Method for reading operation
	public List<Book> getBooks() {
		return BookRepository.findBookList();
	}


	@PostMapping("/admin/addbook") // POST Method for Create operation
	public Book createBook(@Valid @RequestBody Book book) {
		book.setRank(0);
		book.setTitle((book.getTitle().toLowerCase()));
		return BookRepository.save(book);
	}


	@GetMapping("/search/BookId/{id}")
	public Book getBookById(@PathVariable(value = "id") int bookId) throws ResourceNotFoundException {
		Book b = BookRepository.findById(bookId);
		if (b == null) {
			log.error("not found error");

			throw new ResourceNotFoundException("book not found",404);
		}
		return b;
	}


	@GetMapping("/search/category/{category}") // GET Method for Read operation
	public List<Book> getBookByCategory(@PathVariable(value = "cat") String cat) {
		return BookRepository.findByCategory(cat);

	}

	@GetMapping("/quantity/{id}") // GET Method for Read operation
	public int getBookQuantity(@PathVariable(value = "id") int id) {

		return BookRepository.getinventory(id);

	}


	@GetMapping("/search/author/{author}") // GET Method for Read operation
	public List<Book> getBookByAuthor(@PathVariable(value = "author") String auth) {
		// throws ResourceNotFoundException{

		List<Book> b = BookRepository.findByAuthor(auth);
		if (b.isEmpty()) {
			log.error("not found ");
			
			throw new ResourceNotFoundException("book does not exist",404);
		}

		return b;
	}


	@GetMapping("/search/title/{T}") // GET Method for Read operation
	public List<Book> getBookByTitle(@PathVariable(value = "T") String title) {
		List<Book> b = BookRepository.findByTitle(title.toLowerCase());
		if (b.isEmpty()) {
			log.error("not found");
			throw new ResourceNotFoundException("book does not exist",404);
			
		}
		return b;

	}

	@PutMapping("/update/{id}/{quantity}")
	public StatusUpdateResponse updateBookStock(@PathVariable(value = "id") int id,
			@PathVariable(value = "quantity") int quantity) {
		Book book;int stock;
		StatusUpdateResponse res = new StatusUpdateResponse();

		book = BookRepository.findOne(id);
		if (book == null) {

			log.error("not found");
			throw new ResourceNotFoundException("book does not exist", 404);

		}
		stock=book.getInventory();
		book.setInventory(quantity+stock);
		BookRepository.save(book);

		res.setMessage("book inventory updated successfully");
		return res;

	}


	@GetMapping("/popular")
	public List<Book> getPopularBooks() {
		return BookRepository.getPopularBook();

	}


}
