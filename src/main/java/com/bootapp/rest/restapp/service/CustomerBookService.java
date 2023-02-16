package com.bootapp.rest.restapp.service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.CustomerBookRepository;
import com.bootapp.rest.restapp.model.CustomerBook;


@Service
public class CustomerBookService {

	@Autowired
	private  CustomerBookRepository customerBookRepository;

	public void insert(CustomerBook customerBook) {
		customerBookRepository.save(customerBook);
	}
	
	
	
}