package com.nt.beans;

public class Kalanjee {
	private String shoeType;
	private String priceRange;
	
	public void setShoeType(String shoeType) {
		this.shoeType = shoeType;
	}
	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}
	@Override
	public String toString() {
		return "Kalanjee [shoeType=" + shoeType + ", priceRange=" + priceRange + "]";
	}
	
	
}
