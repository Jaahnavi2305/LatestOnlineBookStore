package com.bootapp.rest.restapp.service;

import java.util.List;


import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.CustomerRepository;

import com.bootapp.rest.restapp.model.Customer;
import com.bootapp.rest.restapp.Exception.CustomerNotFoundException;
import com.bootapp.rest.restapp.Exception.NullValueException;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

//
//	public void insertCustomer(Customer customer) {
//		
//		customerRepository.save(customer);
//	}
	public void insertCustomer(Customer customer) throws NullValueException{
		String s1 = customer.getName();
		if (s1 == "") {
			throw new NullValueException("Enter a customer name first");
		} else {
			customerRepository.save(customer);
		}
	}
	

	public List<Customer> getAllCustomers() {

		return customerRepository.findAll();
	}

	public Optional<Customer> getCustomerById(int id) {

		Optional<Customer> optional = customerRepository.findById(id);
		return optional;
	}

	public void PostCustomer(Customer customerDB) {
		customerRepository.save(customerDB);
	}

	public Customer deleteCustomerById(int customerId) throws CustomerNotFoundException{
		
		Optional<Customer> act = customerRepository.findById(customerId);
		if(act.isPresent()) {
			customerRepository.delete(act.get());
			return act.get();
		} else
		{
			throw new CustomerNotFoundException("Customer not Found");
		}
		//customerRepository.delete(optional.get());
		//return optional.get();
	}
//	public List<Customer> getCustomerByBookId(int bid) {
//		List<Customer> list = customerRepository.findAll();
//		
//		List<Customer> filteredList = list.stream() 
//					.filter(e->e.getBook().getId() == bid)
//					.collect(Collectors.toList());
//		
//		return filteredList;
//	}
	
	

}