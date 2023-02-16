package com.bootapp.rest.restapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.CategoryRepository;

import com.bootapp.rest.restapp.model.Category;
import com.bootapp.rest.restapp.Exception.CategoryAlreadyExistsException;
import com.bootapp.rest.restapp.Exception.CategoryNotFoundException;
import com.bootapp.rest.restapp.Exception.NullValueException;


@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

//	public void insertBook(Category category) {
//		categoryRepository.save(category);
//
//	}

	public void insertBook(Category category) throws NullValueException,CategoryAlreadyExistsException {
		List<Category> c1 = categoryRepository.findAll();
		 for( Category c : c1) {
		 if(c.getCategoryName().equalsIgnoreCase(category.getCategoryName())) {
		 throw new CategoryAlreadyExistsException("Category already exists");
		 }
	 }
		
		
				
			String s1 = category.getCategoryName();
			if (s1 == "") {
				throw new NullValueException("Enter a category name first");
			}
			else {
				categoryRepository.save(category);
			}
				}
	

	public List<Category> getAllCategories() {

		return categoryRepository.findAll();
	}

//	public void updatecategoryById(Category category) {
//		categoryRepository.save(category);
//		
//	}

	public Category deleteCategoryById(int categoryId) throws CategoryNotFoundException {
		Optional<Category> cat = categoryRepository.findById(categoryId);
		if(cat.isPresent()) {
			
		
		categoryRepository.delete(cat.get());
		return cat.get();
		}
		else {
			throw new CategoryNotFoundException("category not found");
		}
	}

	public Optional<Category> getCategoryById(int id) {
		Optional<Category> optional = categoryRepository.findById(id);
		return optional;
	}

//	public Optional<Category> getCategoryById1(int id) {
//		
//		 return categoryRepository.findById(id);
//				 }

	public void PostCategory(Category categoryDB) {
		categoryRepository.save(categoryDB);
	}

}
