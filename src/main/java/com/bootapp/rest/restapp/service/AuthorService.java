package com.bootapp.rest.restapp.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.AuthorRepository;
import com.bootapp.rest.restapp.Exception.NullValueException;
import com.bootapp.rest.restapp.Exception.BookAlreadyExistsException;
import com.bootapp.rest.restapp.model.Author;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;

//	public void insertAuthor(Author author) {
//	authorRepository.save(author);
//		
//	}
	public void insertAuthor(Author author) throws NullValueException, BookAlreadyExistsException {
		
		
		List<Author> p1 = authorRepository.findAll();
		      for( Author p : p1) {
		        if(p.getName().equalsIgnoreCase(author.getName())) {
		   throw new BookAlreadyExistsException("name already exists");
	                       }
              }
		String s1 = author.getBook();
		if (s1 == "") {
			throw new NullValueException("Enter a name first");
		} else {
			authorRepository.save(author);
		}
	}

	public List<Author> getAllAuthor() {
		return authorRepository.findAll();

	}

	public Optional<Author> getAuthorById(int authorId) {
		Optional<Author> optional = authorRepository.findById(authorId);
		return optional;
	}

	public void postAuthor(Author authorDB) {
		authorRepository.save(authorDB);
	}

	public Author deleteAuthorById(int authorId) {
		Optional<Author> optional = authorRepository.findById(authorId);
		authorRepository.delete(optional.get());
		return optional.get();
	}
//	public void insertAuthor(Author author) {
//		authorRepository.save(author);
//		
//	}
//	

}