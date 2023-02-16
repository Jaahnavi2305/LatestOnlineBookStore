package com.bootapp.rest.restapp.Exception;

@SuppressWarnings("serial")
public class CategoryNotFoundException extends Exception {
	public CategoryNotFoundException(String msg) {
		super(msg);
	}
}