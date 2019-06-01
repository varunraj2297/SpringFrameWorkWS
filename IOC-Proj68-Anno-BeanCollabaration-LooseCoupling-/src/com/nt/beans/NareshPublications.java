package com.nt.beans;

public class NareshPublications implements MaterialSupplier {
	
	public void supply(int orderid){
		System.out.println("Requested Book are supplied to Student whose orderid is "+orderid+" by Naresh Publications");
	}
}
