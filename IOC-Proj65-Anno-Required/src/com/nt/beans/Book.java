package com.nt.beans;

public class Book {
	private int bid;
	private String bname;
	private float price;
	private String author;
	public void setBid(int bid) {
		this.bid = bid;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", price=" + price + ", author=" + author + "]";
	}
	
	
}
