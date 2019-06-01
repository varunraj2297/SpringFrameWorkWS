package com.nt.beans;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Qualifier;




public class WishMessageGenerator {
    //@Inject
    //@Named("cal2")
    //@Qualifier("c2")
    private Calendar cal=null;

    //@Inject
    //@Named("cal2")
	//@Qualifier("c2")
    public void setCal(/*@Named("cal2") @Qualifier("c2")*/ Calendar cal) {
		this.cal = cal;
	}

    
	public Calendar getCal() {
		return cal;
	}
	

	@Inject
	//@Named("cal2")
	//@Qualifier("c2")  not allowed
	public WishMessageGenerator(Calendar cal) {
		this.cal = cal;
	}
	
	


	public String generate(String user){
		int hour=cal.get(Calendar.HOUR_OF_DAY);
		if(hour<12) 
			return "GM::"+user;
		else if(hour<16)
			return "GA::"+user;
		else if(hour<20)
			return "GE::"+user;
		else
			return "GN::"+user;
	}
}
