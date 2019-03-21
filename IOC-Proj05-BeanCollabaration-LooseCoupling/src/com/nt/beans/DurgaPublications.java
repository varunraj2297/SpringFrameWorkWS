package com.nt.beans;

public class DurgaPublications implements MaterialSupplier {
	
	public void supply(int orderid){
		System.out.println("Requested Book are supplied to Student whose orderid is "+orderid+" by Durga Publications");
	}
}
