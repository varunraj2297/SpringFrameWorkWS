package com.nt.beans;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class WishMessageGenerator {
	@Autowired		//by default required=true
	private Calendar calendar;

	
	public void setCalendar(Calendar calendar){			
		this.calendar=calendar;
	}
	
	public String generate(String user){
		//getting current hour oh the day
		int hour=calendar.get(calendar.HOUR_OF_DAY);
	
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
