package com.nt.beans;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class WishMessageGenerator {
  
	@Autowired
	@Qualifier("cal2")
	private Calendar calender;
	
	
	//@Autowired
	//@Qualifier("calender1")//when matching bean name with param is configured in one bean and in another bean contains primary="true" then primary="true" gets high priority
	public void setCalender(Calendar calender) {//when we configure in one bean with Qualifer and in another bean contains primary="true" then @Qualifier gets high priority
		this.calender = calender;
	}
	
	//@Autowired
	//@Qualifier("calender2")	//matching param name with bean id doesn't work here
	public void assign(/*@Qualifier("cal1")*/ Calendar calendar) {
		this.calender=calendar;//we can also config Qualifier beside  param names
	}
	
	/*@Autowired
	public WishMessageGenerator(@Qualifier("cal2") Calendar calender,Calendar cal) {
		this.calender = calender;
		System.out.println("Calendar::"+cal);
	}*/
	
	public String generator(String user){
		if(calender.get(calender.HOUR_OF_DAY)<12)
			return "GM::"+user;
		else if(calender.getTime().getHours()<16)
			return "GA::"+user;
		else if(calender.getTime().getHours()<20)
			return "GE::"+user;
		else 
			return "GN::"+user;
	}



	@Override
	public String toString() {
		return "WishMessageGenerator [calender=" + calender + "]";
	}
	
}
