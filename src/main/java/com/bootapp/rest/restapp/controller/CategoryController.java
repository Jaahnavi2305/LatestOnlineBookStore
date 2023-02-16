package com.bootapp.rest.restapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.rest.restapp.Exception.CategoryNotFoundException;
import com.bootapp.rest.restapp.Exception.NullValueException;
import com.bootapp.rest.restapp.model.Category;
import com.bootapp.rest.restapp.service.CategoryService;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryservice;
	
	@PostMapping("/add")
	public ResponseEntity<String> postCategory(@RequestBody Category category) throws Exception {
		categoryservice.insertBook(category);
		return ResponseEntity.status(HttpStatus.OK).body("Category posted in DB");
		
	}
	@GetMapping("/getall")
	public List<Category> getAllCategories() {
		List<Category> list = categoryservice.getAllCategories();
		return list;
	}
	
	@PutMapping("/edit/{categoryId}")
	 public ResponseEntity<String> editCategory(@PathVariable("categoryId") int categoryId,@RequestBody Category categoryNew) {
	 /* Step 1: check if this id given is valid by fetching the record from DB */
	Optional<Category> optional = categoryservice.getCategoryById(categoryId);
	if(!optional.isPresent()) {
	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid ID");
	}
	Category categoryDB = optional.get(); 
	 if(categoryNew.getCategoryName() != null)
	 categoryDB.setCategoryName(categoryNew.getCategoryName());
	 
	categoryservice.PostCategory(categoryDB);
	return ResponseEntity.status(HttpStatus.OK).body("category record Edited..");
	}
	
	 @DeleteMapping("/delete/{categoryId}")
	 public ResponseEntity<Object> deleteCategoryById(@PathVariable("categoryId") int categoryId) throws CategoryNotFoundException {
	// Optional<Category> optional = categoryservice.getCategoryById(categoryId);
	 //if (!optional.isPresent())return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ID Given");
	 categoryservice.deleteCategoryById(categoryId);
	 return ResponseEntity.status(HttpStatus.OK).body("Category is deleted");
	 }


}
