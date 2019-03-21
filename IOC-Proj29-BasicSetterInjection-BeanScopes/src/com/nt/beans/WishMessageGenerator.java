package com.nt.beans;

import java.util.Date;

public class WishMessageGenerator {
	private Date date=null;
	
	public void setDate(Date date){			//must be declared as public otherwise container cannot access it
		this.date=date;
	}
	
	public String generate(String user){
		//getting current hour oh the day
		int hour=date.getHours();
	
		if(hour<12)
			return "GM "+user;
		else if(hour<16)
			return "GA "+user;
		else if(hour<20)
			return "GE "+user;
		else 
			return "GN "+user;
		
	}
}
