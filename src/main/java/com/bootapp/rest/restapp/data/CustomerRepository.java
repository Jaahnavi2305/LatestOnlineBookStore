package com.bootapp.rest.restapp.data;

import java.util.List;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapp.rest.restapp.model.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Integer>  {
	Optional<Customer> findById(int customerId);

}