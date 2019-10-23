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
import com.jwt.jwtauth.model.Book;
import com.jwt.jwtauth.model.Order;
import com.jwt.jwtauth.model.StatusUpdateResponse;
import com.jwt.jwtauth.model.item;
import com.jwt.jwtauth.repo.Orderrepo;
import com.jwt.jwtauth.repo.Bookrepo;
import com.jwt.jwtauth.Exceptions.ResourceNotFoundException;



@RestController
@RequestMapping("/store/order")

public class OrderController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Orderrepo OrderRepository;

	@Autowired
	private Bookrepo BookRepository;


	@GetMapping("/") // GET Method for reading operation
	public List<Order> getAllOrders() {
		return OrderRepository.findAll();
	}


	@GetMapping("/summary/{uname}") // GET Method for Read operation
	public List<Order> getOrder(@PathVariable(value = "uname") String uname) throws Exception {

		return OrderRepository.findByName(uname);
	}


	@PutMapping("/update/{id}/{status}")
	public StatusUpdateResponse updateOrder(@PathVariable(value = "id") int id,
			@PathVariable(value = "status") String status) {
		Order orderDetails = OrderRepository.findOne(id);
		StatusUpdateResponse res = new StatusUpdateResponse();
		if (orderDetails == null) {
			res.setMessage("order does not exist");
			return res;
		}
		orderDetails.setStatus(status);
		OrderRepository.save(orderDetails);
		res.setMessage("order updated successfully");
		return res;
	}


	@PostMapping("/") // POST Method for Create operation
	public Order createOrder(@Valid @RequestBody Order order) {
		int bookId, quantity;
		int inventory;
		Book book;
		order.setStatus("Confirmed");
		try{
			List<item> items = order.getItems();

		for (item i : items) {

			bookId = i.getBookid();
			quantity = i.getQuantity();

			inventory = BookRepository.getinventory(bookId);
			book = BookRepository.findOne(bookId);
			book.setRank(book.getRank() + 1);
			if (inventory < quantity) {

				inventory = quantity - inventory;
				i.setQuantity(inventory);

				book.setInventory(0);

			} else {
				inventory -= quantity;
				book.setInventory(inventory);

			}


			
		}

		return OrderRepository.save(order);
	}catch(Exception ex) {
		log.error("internal server error  error code : "+ 500);
throw new ResourceNotFoundException("Internal server error", 500);
		
	}
	}}

