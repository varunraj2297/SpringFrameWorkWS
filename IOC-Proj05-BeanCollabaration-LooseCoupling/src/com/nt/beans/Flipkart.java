package com.nt.beans;

import java.util.Arrays;
import java.util.Random;

public class Flipkart {
	private Courier courier;

	public Flipkart(Courier courier) {
		super();
		this.courier = courier;
	}
	
	public String shopping(String items[]) {
		float BillAmount=0.0f;
		int oid=0;
		String str=null;
		BillAmount=items.length*1000;
		oid=new Random().nextInt(100000);
		str=courier.deliver(oid);
		return str+"\nhaving items "+Arrays.toString(items)+" \nwith BillAmount::"+BillAmount;
	}
}
