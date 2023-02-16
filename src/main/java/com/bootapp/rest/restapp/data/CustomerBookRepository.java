package com.bootapp.rest.restapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapp.rest.restapp.model.CustomerBook;



public interface CustomerBookRepository extends JpaRepository<CustomerBook, Integer> {

}