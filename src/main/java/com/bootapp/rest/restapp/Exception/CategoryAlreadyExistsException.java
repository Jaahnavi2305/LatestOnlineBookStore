package com.bootapp.rest.restapp.Exception;

@SuppressWarnings("serial")
public class CategoryAlreadyExistsException extends Exception {
	public CategoryAlreadyExistsException(String msg) {
		super(msg);
	}
}
