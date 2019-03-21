package com.nt.beans;

public class CourseMaterial {
	private String courseName;
	private int pagesCount;
	private int price;
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void setPagesCount(int pagesCount) {
		this.pagesCount = pagesCount;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CourseMaterial [courseName=" + courseName + ", pagesCount=" + pagesCount + ", price=" + price + "]";
	}
	
	
}
