package com.nt.beans;

import java.util.Arrays;
import java.util.Random;

public class Flipkart {
	private DTDC dtdc;
	public void setDtdc(DTDC dtdc){
		this.dtdc=dtdc;
	}
	
	public String shopping(String item[]) {
		float billAmount=0.0f;
		int orderid=0;
		billAmount=item.length*1000;
		orderid=new Random().nextInt(100000);
		dtdc.deliver(orderid);
		return "items are delivered to custmer whose order id is: "+orderid+"\n having items"+Arrays.toString(item)+"\n with BillAmount:"+billAmount;		
		
	}
	
}
