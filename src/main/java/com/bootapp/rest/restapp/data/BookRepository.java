package com.bootapp.rest.restapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapp.rest.restapp.model.Book;

public interface BookRepository  extends JpaRepository<Book,Integer>{

	

}