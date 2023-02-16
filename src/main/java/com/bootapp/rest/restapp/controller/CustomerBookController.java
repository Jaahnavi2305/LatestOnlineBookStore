package com.bootapp.rest.restapp.controller;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.rest.restapp.model.Book;
import com.bootapp.rest.restapp.model.Customer;
import com.bootapp.rest.restapp.model.CustomerBook;
import com.bootapp.rest.restapp.service.BookService;
import com.bootapp.rest.restapp.service.CustomerBookService;
import com.bootapp.rest.restapp.service.CustomerService;

@RestController
@RequestMapping("/api/customer/book")
public class CustomerBookController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private BookService bookService;
	@Autowired
	private CustomerBookService customerBookService;

	@PostMapping("/add/{customerId}/{bookId}")
	public ResponseEntity<String> PurchaseBook(@PathVariable("customerId") int customerId, @PathVariable("bookId") int bookId,
			@RequestBody CustomerBook customerBook) {
		
            Optional<Book> optionalB = bookService.getBookById(bookId);

		if (!optionalB.isPresent())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Book ID Given");

		Optional<Customer> optionalC = customerService.getCustomerById(customerId);

		if (!optionalC.isPresent())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Customer ID Given");

		Book book = optionalB.get();
		Customer customer = optionalC.get();
		
		customerBook.setBook(book);
		customerBook.setCustomer(customer);
		
		
		customerBookService.insert(customerBook);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book Is Purchased");

		

		
	}







	}
	
	
	