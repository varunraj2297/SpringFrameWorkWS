package com.nt.beans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fpkt")
public class Flipkart {
	
	@Autowired
	@Qualifier("dtdc")		//since courier is user defined we have to go for anno instead of xml 
	private Courier courier;
	

	/*public Flipkart(Courier courier) {
		this.courier = courier;
	}*/
	
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
