package com.bootapp.rest.restapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.AuthorRepository;
import com.bootapp.rest.restapp.data.BookRepository;
import com.bootapp.rest.restapp.data.CategoryRepository;
import com.bootapp.rest.restapp.data.PublisherRepository;
import com.bootapp.rest.restapp.model.Author;
import com.bootapp.rest.restapp.model.Book;
import com.bootapp.rest.restapp.model.Category;
import com.bootapp.rest.restapp.model.Customer;
import com.bootapp.rest.restapp.model.Publisher;
import com.bootapp.rest.restapp.model.Review;


@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private PublisherRepository publisherRepository;


        public void postBook(int cid,int aid,int pid, Book book) {
		 Optional<Author> a1 = authorRepository.findById(aid);
		 book.setAuthor(a1.get());
		 Optional<Publisher> p1 = publisherRepository.findById(pid);
		book.setPublisher(p1.get());
		 Optional<Category> c2 = categoryRepository.findById(cid);
		 book.setCategory(c2.get());
		 book.setId(book.getId());
		book.setName(book.getName());
		 bookRepository.save(book);
		 }
	
	
	public Optional<Book> getBookById(int id) {
     Optional<Book> optional = bookRepository.findById(id);
		return optional;
	}
	
	public List<Book> getBookByCategoryId(int cid) {
		List<Book> list = bookRepository.findAll();
		
		List<Book> filteredList = list.stream() 
					.filter(e->e.getCategory().getId() == cid)
					.collect(Collectors.toList());
		
		return filteredList;
	}
	public List<Book> getBookByAuthorId(int aid) {
		List<Book> list = bookRepository.findAll();
		
		List<Book> filteredList = list.stream() 
					.filter(e->e.getAuthor().getId() == aid)
					.collect(Collectors.toList());
		
		return filteredList;
	}
	public List<Book> getBookByPublisherId(int pid) {
		List<Book> list = bookRepository.findAll();
		
		List<Book> filteredList = list.stream() 
					.filter(e->e.getPublisher().getId() == pid)
					.collect(Collectors.toList());
		
		return filteredList;
	}
	
	
	public void PostBook(Book bookDB) {
		bookRepository.save(bookDB);
	}
	
		
	public Book deleteBookById(int id) {
		Optional<Book> optional = bookRepository.findById(id);
		bookRepository.delete(optional.get());
		return optional.get();
	}
	
	public List<Book> getAllBooks() {
		List<Book> list = bookRepository.findAll();
		return list;
	}
	public List<Book> getBookByName(String name) {
		List<Book> list = bookRepository.findAll();
		List<Book> filteredList = 
				list.stream()
					.filter(e->e.getName().equals(name))
					.collect(Collectors.toList());
		
		return filteredList;
	}
	}






	





	





	






	
	
	
