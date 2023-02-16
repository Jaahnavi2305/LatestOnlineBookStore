package com.bootapp.rest.restapp.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class CustomerBook {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
 
 @ManyToOne
 private Customer customer;
 
 @ManyToOne
 private Book book;
 
 private String purchasedate;
 
 private String couponused;
 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public Book getBook() {
	return book;
}
public void setBook(Book book) {
	this.book = book;
}
public String getCouponused() {
	return couponused;
}
public void setCouponused(String couponused) {
	this.couponused = couponused;
}
public String getPurchasedate() {
	return purchasedate;
}
public void setPurchasedate(String purchasedate) {
	this.purchasedate = purchasedate;
}

}

 