package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("cm")
public class CourseMaterial {
	@Value("1023")
	private int bid;
	@Value("Spring part 1")
	private String bookName;
	@Value("180.0f")
	private float price;
	@Override
	public String toString() {
		return "CourseMaterial [bid=" + bid + ", bookName=" + bookName + ", price=" + price + "]";
	}
	
}
