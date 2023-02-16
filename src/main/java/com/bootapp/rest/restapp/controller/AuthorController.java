package com.bootapp.rest.restapp.controller;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.rest.restapp.Exception.NullValueException;
import com.bootapp.rest.restapp.model.Author;
import com.bootapp.rest.restapp.Exception.BookAlreadyExistsException;
import com.bootapp.rest.restapp.service.AuthorService;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
	@Autowired
	private AuthorService authorService;

	// post api

	@PostMapping("/add")
	public ResponseEntity<String> postAuthor(@RequestBody Author author) throws NullValueException, BookAlreadyExistsException{
		
		authorService.insertAuthor(author);
		return ResponseEntity.status(HttpStatus.OK).body("Author posted in DB");

	}

	// get all

	@GetMapping("/getall")
	public List<Author> getAllAuthor() {
		List<Author> list = authorService.getAllAuthor();
		return list;
	}
	// get by id

	@GetMapping("/one/{authorId}")
	public ResponseEntity<Object> getAuthorById(@PathVariable("authorId") int authorId) {
		Optional<Author> optional = authorService.getAuthorById(authorId);
		if (!optional.isPresent())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ID Given");

		Author author = optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(author);
	}

	// put by id
	@PutMapping("edit/{authorId}")
	public ResponseEntity<String> editAuthor(@PathVariable("authorId") int authorId, @RequestBody Author authorNew)
	{
		Optional<Author> optional = authorService.getAuthorById(authorId);
		if(!optional.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid Id");
		}
		Author authorDB = optional.get();
			if(authorNew.getName() != null)
				authorDB.setName(authorNew.getName());
			if(authorNew.getBook() != null)
				
				authorDB.setBook(authorNew.getBook());
			authorService.postAuthor(authorDB);
			return ResponseEntity.status(HttpStatus.OK).body("author recorded edited");
			
			
		}
	

	//delete by id

	@DeleteMapping("/delete/{authorId}")
       public ResponseEntity<Object> deleteAuthorById(@PathVariable("authorId") int authorId ){
     Optional<Author> optional = authorService.getAuthorById(authorId);
     if (!optional.isPresent())return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ID Given");
	 authorService.deleteAuthorById(authorId);
	 return ResponseEntity.status(HttpStatus.OK).body("author is deleted");

}
}