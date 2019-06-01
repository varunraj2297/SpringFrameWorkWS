package com.nt.beans;

import java.util.Arrays;
import java.util.Random;

public class BookShop {
	private MaterialSupplier materialSupplier;

	public BookShop(MaterialSupplier materialSupplier) {
		super();
		this.materialSupplier=materialSupplier;
	}
	
	public String purchase(String[] books) {
		float BillAmount=0.0f;
	
		int orderid=0;
		BillAmount=books.length*150;
		
		orderid=new Random().nextInt(10000);
		materialSupplier.supply(orderid);
		
		return "\nlist of books:-"+Arrays.toString(books)+" \nwith BillAmount::"+BillAmount;
	}
}
