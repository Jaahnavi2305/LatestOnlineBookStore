package com.bootapp.rest.restapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.rest.restapp.model.Author;
import com.bootapp.rest.restapp.model.Book;
import com.bootapp.rest.restapp.model.Category;
import com.bootapp.rest.restapp.model.Customer;
import com.bootapp.rest.restapp.model.Publisher;
import com.bootapp.rest.restapp.model.Review;
import com.bootapp.rest.restapp.service.AuthorService;
import com.bootapp.rest.restapp.service.BookService;
import com.bootapp.rest.restapp.service.CategoryService;
import com.bootapp.rest.restapp.service.PublisherService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private CategoryService categoryservice;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private PublisherService publisherService;

	/* Book POST API */

	 @PostMapping("/add/{cid}/{aid}/{pid}")
	 public ResponseEntity<String> postBook(@RequestBody Book book,
	 @PathVariable("cid") int cid,
	 @PathVariable("aid") int aid,
	 @PathVariable("pid")int pid){
	 bookService.postBook(cid,aid,pid,book);
	 return ResponseEntity.status(HttpStatus.OK).body("Book Posted in DB");
	}
   /*get book by Id*/
	@GetMapping("/one/{id}")
	public ResponseEntity<Object> getBookById(@PathVariable("id") int id) {
		Optional<Book> optional = bookService.getBookById(id);
		if (optional == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id Given");

		Book book = optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(book);
	}
	 /*get book by categoryId*/
	@GetMapping("/category/{cid}")
	public List<Book> getBookByCategoryId(@PathVariable("cid") int cid) {
		List<Book> list = bookService.getBookByCategoryId(cid);
		return list;
	}
		 /*get book by authorId*/
		@GetMapping("/author/{aid}")
		public List<Book> getBookByAuthorId(@PathVariable("aid") int aid) {
			List<Book> list = bookService.getBookByAuthorId(aid);
			return list;
		}
			 /*get book by publisherId*/
			@GetMapping("/publisher/{pid}")
			public List<Book> getBookByPublisherId(@PathVariable("pid") int pid) {
				List<Book> list = bookService.getBookByPublisherId(pid);
				return list;
		
	}
	/* edit  API */
	@PutMapping("/edit/{id}")
	public ResponseEntity<String> edit(@PathVariable("id") int id, @RequestBody Book bookNew) {
		Optional<Book> optional = bookService.getBookById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid ID");
		}
		Book bookDB = optional.get(); 
		if (bookNew.getName() != null)
			bookDB.setName(bookNew.getName());
		bookService.PostBook(bookDB);
		return ResponseEntity.status(HttpStatus.OK).body("book record Edited..");
	}
	/* delete API */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteBookById(@PathVariable("id") int id) {
	
		bookService.deleteBookById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Book is deleted");
	}

	/* Get All API */
	@GetMapping("/getall")
 public List<Book> getAllBooks() {
 List<Book> list = bookService.getAllBooks();
 return list;
 }
	 /*get book by name*/
		@GetMapping("/name/{name}")
		public List<Book> getBookByName(
				@PathVariable("name") String name) {
			
			List<Book> list = bookService.getBookByName(name);
			return list; 
		}

}