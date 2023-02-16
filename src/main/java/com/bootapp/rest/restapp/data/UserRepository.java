package com.bootapp.rest.restapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bootapp.rest.restapp.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select u from User u where u.username=?1")
	User getUserByUsername(String username);

}