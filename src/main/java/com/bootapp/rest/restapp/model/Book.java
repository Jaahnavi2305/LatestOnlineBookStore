package com.bootapp.rest.restapp.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Book {
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
		private int id; 
		
		@Column(name="book_name")
		private String name;  
		@ManyToOne
		private  Publisher publisher;   
		 @ManyToOne
		private Author author;
		@ManyToOne
		private Category category;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Publisher getPublisher() {
			return publisher;
		}
		public void setPublisher(Publisher publisher) {
			this.publisher = publisher;
		}
		public Author getAuthor() {
			return author;
		}
		public void setAuthor(Author author) {
			this.author = author;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		
		

	

	
	}	
		
		
		

	

