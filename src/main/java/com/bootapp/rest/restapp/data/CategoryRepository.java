package com.bootapp.rest.restapp.data;

import org.springframework.data.jpa.repository.JpaRepository;


import com.bootapp.rest.restapp.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
