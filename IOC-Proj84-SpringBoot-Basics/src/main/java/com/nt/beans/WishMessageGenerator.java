package com.nt.beans;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	@Autowired
	private Calendar calendar;

	
	public String generate(String user){
		int hour=0;
		hour=calendar.get(Calendar.HOUR_OF_DAY);
	
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
